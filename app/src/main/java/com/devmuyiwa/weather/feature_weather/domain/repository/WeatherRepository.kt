package com.devmuyiwa.weather.feature_weather.domain.repository

import com.devmuyiwa.weather.core.util.Resource
import com.devmuyiwa.weather.feature_weather.domain.model.WeatherForecast
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherForecast(location: String, noOfDays: Int): Flow<Resource<WeatherForecast>>
}