package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Forecastday(
    @Expose
    val date: String,
    @Expose
    val hour: List<Hour>
)