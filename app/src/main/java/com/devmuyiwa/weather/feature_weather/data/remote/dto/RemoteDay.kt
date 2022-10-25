package com.devmuyiwa.weather.feature_weather.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteDay(
    @field:Json(name = "maxtemp_c") val maxTempC: Double?,
    @field:Json(name = "maxtemp_f") val maxTempF: Double?,
    @field:Json(name = "mintemp_c") val minTempC: Double?,
    @field:Json(name = "mintemp_f") val minTempF: Double?,
    @field:Json(name = "maxwind_mph") val maxWindMph: Double?,
    @field:Json(name = "maxwind_kph") val maxWindKph: Double?,
    @field:Json(name = "totalprecip_mm") val totalPrecipMm: Double?,
    @field:Json(name = "totalprecip_in") val totalPrecipIn: Double?,
    @field:Json(name = "avgvis_km") val avgVisKm: Double?,
    @field:Json(name = "avgvis_miles") val avgVisMiles: Double?,
    @field:Json(name = "avghumidity") val averageHumidity: Double?,
    @field:Json(name = "uv") val uv: Double?
)