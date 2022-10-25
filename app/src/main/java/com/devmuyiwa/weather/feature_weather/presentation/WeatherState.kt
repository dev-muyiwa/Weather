package com.devmuyiwa.weather.feature_weather.presentation

import com.devmuyiwa.weather.feature_weather.domain.model.WeatherForecast
import com.devmuyiwa.weather.feature_weather.util.Event

data class WeatherState(
    val isLoading: Boolean = false,
    val weatherForecast: WeatherForecast? = null,
    val error: Event<String>? = null
)
