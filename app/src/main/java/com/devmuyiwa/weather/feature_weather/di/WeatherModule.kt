package com.devmuyiwa.weather.feature_weather.di

import com.devmuyiwa.weather.feature_weather.data.local.dao.ForecastDao
import com.devmuyiwa.weather.feature_weather.data.remote.WeatherApi
import com.devmuyiwa.weather.feature_weather.data.repository.WeatherApiRepository
import com.devmuyiwa.weather.feature_weather.domain.repository.WeatherRepository
import com.devmuyiwa.weather.feature_weather.domain.usecases.GetWeeklyWeatherForecast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {
    @Provides
    @Singleton
    fun provideGetWeeklyWeatherUseCase(
        repository: WeatherRepository,
        ioDispatcher: CoroutineDispatcher
    ): GetWeeklyWeatherForecast = GetWeeklyWeatherForecast(repository, ioDispatcher)

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: WeatherApi,
        dao: ForecastDao
    ): WeatherRepository = WeatherApiRepository(api, dao)

    @Provides
    @Singleton
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}