package com.devmuyiwa.weather.feature_weather.data.local.entities

import com.squareup.moshi.*


@JsonClass(generateAdapter = true)
data class LocalCurrentWeather(
    val lastUpdatedEpoch: Long,
    val tempInC: Double,
    val tempInF: Double,
    val isDay: Int,
    val weatherText: String,
    val weatherIconUrl: String,
    val weatherCode: Int,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDirection: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val precipMm: Double,
    val precipIn: Double,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeC: Double,
    val feelsLikeF: Double,
    val visKm: Double,
    val visMiles: Double,
    val uv: Double,
    val gustMph: Double,
    val gustKph: Double,
)