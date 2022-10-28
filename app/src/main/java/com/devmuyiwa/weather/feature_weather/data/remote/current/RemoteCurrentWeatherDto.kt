package com.devmuyiwa.weather.feature_weather.data.remote.current


import com.devmuyiwa.weather.feature_weather.data.remote.forecastDto.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteCurrentWeatherDto(
    @field:Json(name = "location") val location: RemoteLocation?,
    @field:Json(name = "current") val currentWeather: RemoteCurrentWeather?,
    @field:Json(name = "forecast") val forecast: RemoteForecast?
)