package com.devmuyiwa.weather.feature_weather.di

import com.devmuyiwa.weather.feature_weather.data.local.WeatherDb
import com.devmuyiwa.weather.feature_weather.data.local.dao.ForecastDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun provideMoviesDao(db: WeatherDb): ForecastDao = db.getForecastDao()

}