package com.devmuyiwa.weather.feature_weather.data.remote

import com.devmuyiwa.weather.feature_weather.data.remote.dto.RemoteForecastDto
import com.devmuyiwa.weather.feature_weather.data.remote.util.FORECAST_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(FORECAST_ENDPOINT)
    suspend fun getWeatherForecastData(
        @Query("q") location: String,
        @Query("days") noOfDays: Int,
    ): RemoteForecastDto
}