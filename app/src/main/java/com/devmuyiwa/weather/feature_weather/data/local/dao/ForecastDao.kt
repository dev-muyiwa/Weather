package com.devmuyiwa.weather.feature_weather.data.local.dao

import androidx.room.*
import com.devmuyiwa.weather.feature_weather.data.local.entities.*

@Dao
abstract class ForecastDao {
    @Query("SELECT * FROM ${LocalWeatherWithForecast.WEATHER_FORECAST} WHERE name = (:location)")
    abstract suspend fun getWeeklyForecast(location: String): LocalWeatherWithForecast

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertWeeklyForecast(forecast: LocalWeatherWithForecast): Long

    @Query("DELETE FROM ${LocalWeatherWithForecast.WEATHER_FORECAST} WHERE name = (:location)")
    abstract suspend fun deleteWeeklyForecastByLocation(location: String)
}