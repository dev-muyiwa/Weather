package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Location(
    @Expose
    val name: String,
    @Expose
    val region: String,
    @Expose
    val country: String,
    @Expose
    val lat: Double,
    @Expose
    val lon: Double,
    @Expose
    val localtime: String
)