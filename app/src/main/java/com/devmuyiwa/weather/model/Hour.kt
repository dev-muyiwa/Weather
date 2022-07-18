package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Hour(
    @Expose
    val time: String,
    @SerializedName("temp_c")
    @Expose
    val tempC: Double,
    @SerializedName("is_day")
    @Expose
    val isDay: Int,
    @Expose
    val condition: Condition,
    @SerializedName("wind_kph")
    @Expose
    val windKph: Double,
    @Expose
    val humidity: Int
)