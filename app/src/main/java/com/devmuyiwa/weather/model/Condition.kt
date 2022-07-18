package com.devmuyiwa.weather.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Condition(
    @Expose
    val text: String,
    @Expose
    val icon: String,
    @Expose
    val code: Int
)