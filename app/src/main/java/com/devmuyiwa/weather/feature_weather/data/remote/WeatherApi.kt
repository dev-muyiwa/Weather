package com.devmuyiwa.weather.feature_weather.data.remote

import com.devmuyiwa.weather.feature_weather.data.remote.forecastDto.*
import com.devmuyiwa.weather.feature_weather.data.remote.util.*
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(CURRENT_ENDPOINT)
    suspend fun getCurrentWeather(@Query("q") location: String): RemoteForecast

    @GET(FORECAST_ENDPOINT)
    suspend fun getWeatherForecastData(
        @Query("q") location: String,
        @Query("days") noOfDays: Int,
    ): RemoteWeatherForecastDto
}