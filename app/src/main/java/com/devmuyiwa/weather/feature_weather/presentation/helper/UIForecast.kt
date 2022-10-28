package com.devmuyiwa.weather.feature_weather.presentation.helper

data class UIForecast(
	val astrology: UIAstro,
	val day: UIDay,
	val hourlyForecast: List<UIHourlyForecast>
)

data class Stats(
	val name: String,
	val value: String
)

fun UIForecast.toStatsList(): List<Stats> {
	val stats: ArrayList<Stats> = ArrayList()
	stats.add(Stats("sunrise", astrology.sunrise))
	stats.add(Stats("sunset", astrology.sunset))
	stats.add(Stats("precipitation", day.precipitation))
	stats.add(Stats("humidity", day.humidity))
	stats.add(Stats("wind", day.wind))
	stats.add(Stats("visibility", day.visibility))
	return stats
}