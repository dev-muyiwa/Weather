package com.devmuyiwa.weather.feature_weather.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteLocation(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "region") val region: String?,
    @field:Json(name = "country") val country: String?,
    @field:Json(name = "lat") val latitude: Double?,
    @field:Json(name = "lon") val longitude: Double?,
    @field:Json(name = "tz_id") val tzId: String?,
    @field:Json(name = "localtime_epoch") val localtimeEpoch: Long?,
    @field:Json(name = "localtime") val localtime: String?
)