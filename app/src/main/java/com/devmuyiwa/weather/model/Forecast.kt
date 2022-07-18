package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Forecast(
    @Expose
    @SerializedName("forecastday")
    val forecastDay: List<Forecastday>
)