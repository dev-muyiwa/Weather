package com.devmuyiwa.weather.feature_weather.domain.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class WeatherForecast(
    val location: Location,
    val currentWeather: CurrentWeather,
    val forecast: List<DailyForecast>,
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val tzId: String,
    val localDateTime: LocalDateTime,
)

data class CurrentWeather(
    val lastUpdated: LocalDateTime,
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

data class DailyForecast(
    val date: LocalDate,
    val day: Day,
    val astrology: Astrology,
    val hourlyForecast: List<HourlyForecast>,
)

data class Astrology(
    val sunrise: String,
    val sunset: String,
)

data class Day(
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

data class HourlyForecast(
    val timeEpoch: LocalTime,
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