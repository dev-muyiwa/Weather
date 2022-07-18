package com.devmuyiwa.weather.presentation

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devmuyiwa.weather.R
import com.devmuyiwa.weather.databinding.FragmentHomeBinding
import com.devmuyiwa.weather.model.Forecast
import com.devmuyiwa.weather.model.Hour
import com.devmuyiwa.weather.presentation.adapter.PerHourAdapter
import com.devmuyiwa.weather.presentation.helper.PerHourHelper
import com.devmuyiwa.weather.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()

    private lateinit var location: String
    private lateinit var listOfHourWeather: List<Hour>
    private var listOfHourlyData: ArrayList<PerHourHelper> = ArrayList()
    private var currentHourList: Hour? = null
    private lateinit var hourlyAdapter: PerHourAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherResponse.observe(viewLifecycleOwner, Observer { weather ->
            listOfHourWeather = weather.forecast.forecastDay[0].hour
            val hour =  LocalDateTime.now().hour
            var currentHour = ""
            if (hour < 10){
                currentHour = "0${hour}:00"
            }else{
                currentHour = "${hour}:00"
            }

            parseHourToArrayList()
            addHourToRecyclerView()
            validateCurrentTimeFromList(currentHour)
            binding.apply{
                tvLocation.text = "${weather.location.name}, ${weather.location.country}"
                val imageUrl = "https:${currentHourList?.condition?.icon}"
                weatherIcon.load(imageUrl)
                tvWeatherDesc.text = currentHourList?.condition?.text
                tvWeatherTemp.text = "${currentHourList?.tempC}"
                tvWindSpeed.text = "${currentHourList?.windKph} km/h"
//                tvWindSpeed.text = getTimeFromString(listOfHourWeather[0].time)
                tvWeatherHumidity.text = "${currentHourList?.humidity} %"
//                tvWeatherHumidity.text = currentHour
            }



        })
    }

    private fun parseHourToArrayList(){
        lateinit var info: Any
        for (i in 1..listOfHourWeather.size){
            info = listOfHourWeather[i - 1]
            listOfHourlyData.add(PerHourHelper(info.time, info.condition.icon, info.tempC))
        }
    }

    private fun addHourToRecyclerView() {
        binding.hourlyRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
                false)
        }
        binding.hourlyRecyclerView.adapter = PerHourAdapter(listOfHourlyData)
    }

    private fun getTimeFromString(time: String): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val localDateTime = LocalDateTime.parse(time, pattern)
        val localTime = localDateTime.toLocalTime()
        return localTime.toString()
    }

    private fun validateCurrentTimeFromList(currentHour: String){
        for (i in 1..listOfHourWeather.size){
            if (currentHour == getTimeFromString(listOfHourWeather[i-1].time)){
                currentHourList = listOfHourWeather[i-1]
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}