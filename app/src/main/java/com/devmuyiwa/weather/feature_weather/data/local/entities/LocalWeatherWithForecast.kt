package com.devmuyiwa.weather.feature_weather.data.local.entities

import androidx.room.*

@Entity(tableName = LocalWeatherWithForecast.WEATHER_FORECAST)
data class LocalWeatherWithForecast(
    @PrimaryKey(autoGenerate = true) val forecastId: Int,
    @Embedded val location: LocalLocation,
    @Embedded val currentWeather: LocalCurrentWeather,
    val forecast: List<LocalDailyForecast>,
){
    companion object {
        const val WEATHER_FORECAST = "Forecast"
    }
}
