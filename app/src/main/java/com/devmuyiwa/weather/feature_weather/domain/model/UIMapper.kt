package com.devmuyiwa.weather.feature_weather.domain.model

import android.os.*
import androidx.annotation.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*
import com.devmuyiwa.weather.feature_weather.util.*
import java.time.*
import kotlin.math.*

private fun HourlyForecast.toUIModel(): UIHourlyForecast {
	return UIHourlyForecast(
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
	)
}

fun DailyForecast.toUIModel(): UIForecast{
	return UIForecast(
		astrology = astrology.toUIModel(),
		day = day.toUIModel(),
		hourlyForecast = hourlyForecast.map { it.toUIModel() }
	)
}

private fun Day.toUIModel(): UIDay {
	return UIDay(
		precipitation = "$totalPrecipMm mm",
		humidity = "$averageHumidity%",
		wind = "$maxWindKph km/h",
		visibility = "${avgVisKm.toStringValue()} km"
	)
}

private fun Astrology.toUIModel(): UIAstro {
	return UIAstro(
		sunrise = sunrise,
		sunset = sunset
	)
}