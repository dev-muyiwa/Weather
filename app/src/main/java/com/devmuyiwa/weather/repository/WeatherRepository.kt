package com.devmuyiwa.weather.repository

import com.devmuyiwa.weather.api.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeatherData()
}