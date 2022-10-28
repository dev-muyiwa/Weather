package com.devmuyiwa.weather.feature_weather.data.remote.forecastDto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteForecast(
    @field:Json(name = "forecastday") val forecast: List<RemoteDailyForecast>?
)