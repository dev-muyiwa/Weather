package com.devmuyiwa.weather.feature_weather.presentation.helper

data class UICurrentWeather(
	val day: String,
	val date: String,
	val temperature: String,
	val degreeType: String,
	val feelsLikeTemp: String,
	val precipitation: String,
	val humidity: String,
	val wind: String,
	val pressure: String
)
