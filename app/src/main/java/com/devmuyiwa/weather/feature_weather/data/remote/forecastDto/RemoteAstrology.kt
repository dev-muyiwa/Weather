package com.devmuyiwa.weather.feature_weather.data.remote.forecastDto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteAstrology(
    @field:Json(name = "sunrise") val sunrise: String?,
    @field:Json(name = "sunset") val sunset: String?,
)