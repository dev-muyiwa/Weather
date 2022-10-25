package com.devmuyiwa.weather.feature_weather.domain.model

import android.os.*
import androidx.annotation.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*
import com.devmuyiwa.weather.feature_weather.util.*
import java.time.*
import kotlin.math.*

fun HourlyForecast.toUIModel(): UIHourlyStats {
	return UIHourlyStats(
		time = timeEpoch.to12HourFormat(), icon = weatherIconUrl,
		temperature = "${tempC.toStringValue()}°"
	)
}

@RequiresApi(Build.VERSION_CODES.O)
fun CurrentWeather.toUIModel(): UICurrentWeather {
	return UICurrentWeather(
		day = "Today",
		date = LocalDate.now().toDate(),
		temperature = tempInC.toStringValue(),
		degreeType = "°C",
		feelsLikeTemp = "Feels like ${feelsLikeC.toStringValue()}°",
		precipitation = "$precipMm mm",
		humidity = "$humidity%",
		wind = "$windKph km/h",
		pressure = "${pressureMb.toStringValue()} hPa"
//		temperature = "$tempInC"
	)
}