package com.devmuyiwa.weather.feature_weather.data.remote.forecastDto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteDailyForecast(
    @field:Json(name = "date") val date: String?,
    @field:Json(name = "date_epoch") val dateEpoch: Long?,
    @field:Json(name = "day") val day: RemoteDay?,
    @field:Json(name = "astro") val astrology: RemoteAstrology?,
    @field:Json(name = "hour") val hourlyForecast: List<RemoteHourlyForecast>?
)