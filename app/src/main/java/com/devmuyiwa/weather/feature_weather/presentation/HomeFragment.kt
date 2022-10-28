package com.devmuyiwa.weather.feature_weather.presentation

import android.graphics.*
import android.os.*
import android.view.*
import android.widget.*
import androidx.core.view.*
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import com.devmuyiwa.weather.R
import com.devmuyiwa.weather.databinding.*
import com.devmuyiwa.weather.feature_weather.domain.model.*
import com.devmuyiwa.weather.feature_weather.presentation.adapter.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*
import com.devmuyiwa.weather.feature_weather.presentation.viewmodel.*
import com.devmuyiwa.weather.feature_weather.util.*
import com.google.android.material.snackbar.*
import dagger.hilt.android.*
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()
    private var snackBar: Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // store in the view model
        toggleListener(view)
        setupUI()
    }

    private fun toggleListener(view: View) {
        val selectedRadioButton = view.findViewById(binding.daySelector.checkedRadioButtonId)
                as RadioButton
        selectedRadioButton.textSize = 24f

        binding.daySelector.setOnCheckedChangeListener { group, checkedId ->
            val checkedOption = group?.findViewById<RadioButton>(checkedId)
            when (checkedId) {
                R.id.today_weather -> {
                    group.findViewWithTag<RadioButton>("Tomorrow").textSize = 16f
                    checkedOption?.textSize = 24f
//                    getForecast(0)
                    Toast.makeText(requireContext(), "Today", Toast.LENGTH_SHORT).show()
                }
                R.id.tomorrow_weather -> {
                    group.findViewWithTag<RadioButton>("Today").textSize = 16f
                    checkedOption?.textSize = 24f
//                    getForecast(1)
                    Toast.makeText(requireContext(), "Tomorrow", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupUI() {
        val hourlyAdapter = createHourlyAdapter()
        val statsAdapter = createStatsAdapter()
        refreshListener()
        setupHourlyRecyclerView(hourlyAdapter)
        setupCurrentStatsAdapter(statsAdapter)
        subscribeToUpdates(hourlyAdapter, statsAdapter)
    }

    private fun refreshListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            fetchWeather()
            binding.swipeRefreshLayout.isRefreshing = false
            snackBar?.dismiss()
        }
    }

    private fun createHourlyAdapter(): HourlyWeatherAdapter {
        return HourlyWeatherAdapter(requireContext())
    }

    private fun createStatsAdapter(): CurrentStatsAdapter {
        return CurrentStatsAdapter(requireContext())
    }

    private fun setupHourlyRecyclerView(statsAdapter: HourlyWeatherAdapter) {
        val snapHelper = LinearSnapHelper()
        binding.hourlyRecyclerView.apply {
            adapter = statsAdapter
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL, false
            )
            hasFixedSize()
        }
        snapHelper.attachToRecyclerView(binding.hourlyRecyclerView)
    }

    private fun setupCurrentStatsAdapter(statsAdapter: CurrentStatsAdapter) {
        binding.currentStats.apply {
            adapter = statsAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            hasFixedSize()
        }
    }

    private fun subscribeToUpdates(
        hourlyAdapter: HourlyWeatherAdapter,
        statsAdapter: CurrentStatsAdapter
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    updateUi(it, hourlyAdapter, statsAdapter)
                }
            }
        }
    }

    private fun updateUi(
        state: WeatherState,
        hourlyAdapter: HourlyWeatherAdapter,
        statsAdapter: CurrentStatsAdapter
    ) {
        val currentWeather = state.weatherForecast?.currentWeather?.toUIModel()
        val todayForecast = state.weatherForecast?.forecast?.get(0)?.toUIModel()
        val tomorrowForecast = state.weatherForecast?.forecast?.get(1)?.toUIModel()
        binding.day.text = currentWeather?.day
        binding.currentForecastDate.text = currentWeather?.date
        binding.currentTemperature.text = currentWeather?.temperature
        binding.feelsLikeTemperature.text = currentWeather?.feelsLikeTemp
        binding.degreeType.text = currentWeather?.degreeType
        hourlyAdapter.submitList(
            if (binding.daySelector.checkedRadioButtonId == R.id.today_weather)
                todayForecast?.hourlyForecast else tomorrowForecast?.hourlyForecast
        )
        statsAdapter.submitList(todayForecast?.toStatsList())
        binding.progressBar.isVisible = state.isLoading
        binding.currentStats.isVisible = ! state.isLoading
        handleFailure(state.error)
    }

    private fun handleFailure(failure: Event<String>?) {
        val unhandledFailure = failure?.getContent() ?: return
        val message = "An error occurred, try again later!"
        val toast = unhandledFailure.ifEmpty { message }
        snackBar = Snackbar.make(binding.rootLayout, "", Snackbar.LENGTH_INDEFINITE)
        val customLayout = layoutInflater.inflate(R.layout.snackbar_layout, null) as RelativeLayout
        snackBar !!.view.setBackgroundColor(Color.TRANSPARENT)
        val customSnackBarLayout = snackBar !!.view as Snackbar.SnackbarLayout
        customSnackBarLayout.setPadding(0, 0, 0, 0)
        customLayout.findViewById<TextView>(R.id.message).text = toast
        customLayout.findViewById<TextView>(R.id.retry_text).setOnClickListener {
            fetchWeather()
            snackBar !!.dismiss()
        }
        customSnackBarLayout.addView(customLayout)
        snackBar !!.show()
    }

    private fun fetchWeather() {
        viewModel.onEvent(WeatherEvent.DisplayWeeklyWeather)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        snackBar = null
    }
}