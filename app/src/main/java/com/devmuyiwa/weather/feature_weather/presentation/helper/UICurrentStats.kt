package com.devmuyiwa.weather.feature_weather.presentation.helper

data class UICurrentStats(
    val sunrise: String,
    val sunset: String,
    val precipitation: String,
    val humidity: String,
    val windSpeed: String,
    val pressure: String
)

fun UICurrentStats.toStatsList(): List<Stats> {
    val stats: ArrayList<Stats> = ArrayList()
    stats.add(Stats("sunrise", sunrise))
    stats.add(Stats("sunset", sunset))
    stats.add(Stats("precipitation", precipitation))
    stats.add(Stats("humidity", humidity))
    stats.add(Stats("wind", windSpeed))
    stats.add(Stats("pressure", pressure))

    return stats
}