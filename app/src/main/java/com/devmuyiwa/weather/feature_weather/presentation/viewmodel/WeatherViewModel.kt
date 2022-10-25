package com.devmuyiwa.weather.feature_weather.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmuyiwa.weather.core.util.Resource
import com.devmuyiwa.weather.feature_weather.domain.model.WeatherForecast
import com.devmuyiwa.weather.feature_weather.domain.usecases.GetWeeklyWeatherForecast
import com.devmuyiwa.weather.feature_weather.presentation.WeatherEvent
import com.devmuyiwa.weather.feature_weather.presentation.WeatherState
import com.devmuyiwa.weather.feature_weather.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeeklyWeatherForecast: GetWeeklyWeatherForecast
) : ViewModel() {
    private val noOfDays = 2
    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state.asStateFlow()

    init {
        getWeather("Lagos")
    }

    fun onEvent(event: WeatherEvent) {
        when (event) {
            is WeatherEvent.DisplayWeeklyWeather -> getWeeklyWeather()
        }
    }

    private fun getWeather(location: String) {
        viewModelScope.launch {
            getWeeklyWeatherForecast(location, noOfDays).onEach { result ->
                when (result) {
                    is Resource.Loading -> onLoading(result)
                    is Resource.Success -> onSuccess(result)
                    is Resource.Error -> onFailure(result)
                }
            }.launchIn(this)
        }
    }

    private fun getWeeklyWeather() {
        if (state.value.weatherForecast != null) {
            getWeather("Lagos")
        }
    }

    private fun onLoading(result: Resource<WeatherForecast>) {
        _state.update { oldState ->
            oldState.copy(
                isLoading = true,
                weatherForecast = result.data
            )
        }
    }

    private fun onSuccess(result: Resource<WeatherForecast>) {
        _state.update { oldState ->
            oldState.copy(
                isLoading = false,
                weatherForecast = result.data
            )
        }
    }

    private fun onFailure(result: Resource<WeatherForecast>) {
        _state.update { oldState ->
            oldState.copy(
                isLoading = false,
                weatherForecast = result.data,
                error = Event(result.message.orEmpty())
            )
        }
    }
}