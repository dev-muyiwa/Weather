package com.devmuyiwa.weather.feature_weather.data.local.entities

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class LocalDailyForecast(
    val dateEpoch: Long,
    val day: LocalDay,
    val astrology: LocalAstrology,
    val hourlyForecast: List<LocalHourlyForecast>,
)

data class LocalDay(
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double,
    val maxWindMph: Double,
    val maxWindKph: Double,
    val totalPrecipMm: Double,
    val totalPrecipIn: Double,
    val avgVisKm: Double,
    val avgVisMiles: Double,
    val averageHumidity: Double,
    val uv: Double,
)

data class LocalAstrology(
    val sunrise: String,
    val sunset: String,
)

data class LocalHourlyForecast(
    val timeEpoch: Long,
    val time: String,
    val tempC: Double,
    val tempF: Double,
    val isDay: Int,
    val weatherText: String,
    val weatherIconUrl: String,
    val weatherCode: Int,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDir: String,
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
)
