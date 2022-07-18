package com.devmuyiwa.weather.api

import com.devmuyiwa.weather.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("q") location: String = "Lagos",
        @Query("days") noOfDays: Int = 1
    ): Response<WeatherData>
}