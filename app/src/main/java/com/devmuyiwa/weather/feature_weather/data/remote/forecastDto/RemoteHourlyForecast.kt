package com.devmuyiwa.weather.feature_weather.data.remote.forecastDto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteHourlyForecast(
    @field:Json(name = "time_epoch") val timeEpoch: Long?,
    @field:Json(name = "time") val time: String?,
    @field:Json(name = "temp_c") val tempC: Double?,
    @field:Json(name = "temp_f") val tempF: Double?,
    @field:Json(name = "is_day") val isDay: Int?,
    @field:Json(name = "condition") val condition: Condition?,
    @field:Json(name = "wind_mph") val windMph: Double?,
    @field:Json(name = "wind_kph") val windKph: Double?,
    @field:Json(name = "wind_degree") val windDegree: Int?,
    @field:Json(name = "wind_dir") val windDir: String?,
    @field:Json(name = "pressure_mb") val pressureMb: Double?,
    @field:Json(name = "pressure_in") val pressureIn: Double?,
    @field:Json(name = "precip_mm") val precipMm: Double?,
    @field:Json(name = "precip_in") val precipIn: Double?,
    @field:Json(name = "humidity") val humidity: Int?,
    @field:Json(name = "cloud") val cloud: Int?,
    @field:Json(name = "feelslike_c") val feelsLikeC: Double?,
    @field:Json(name = "feelslike_f") val feelsLikeF: Double?,
    @field:Json(name = "vis_km") val visKm: Double?,
    @field:Json(name = "vis_miles") val visMiles: Double?,
)