package com.devmuyiwa.weather.feature_weather.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devmuyiwa.weather.feature_weather.data.local.dao.ForecastDao
import com.devmuyiwa.weather.feature_weather.data.local.entities.LocalWeatherWithForecast

@Database(
    entities = [LocalWeatherWithForecast::class],
    exportSchema = true,
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeatherDb : RoomDatabase() {
    abstract fun getForecastDao(): ForecastDao
}