package com.devmuyiwa.weather.feature_weather.util

import kotlin.math.*

fun Double.toStringValue(): String{
	return if (this - this.toInt() != 0.0 ) "$this" else "${this.roundToInt()}"
}