package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class WeatherData(
    @Expose
    val location: Location,
    @Expose
    val forecast: Forecast
)