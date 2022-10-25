package com.devmuyiwa.weather.feature_weather.data.remote.dto


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String?,
    val icon: String?,
    val code: Int?,
)