package com.devmuyiwa.weather.feature_weather.domain.usecases

import com.devmuyiwa.weather.core.util.Resource
import com.devmuyiwa.weather.feature_weather.domain.model.WeatherForecast
import com.devmuyiwa.weather.feature_weather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeeklyWeatherForecast @Inject constructor(
    private val repository: WeatherRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(location: String, noOfDays: Int): Flow<Resource<WeatherForecast>> {
        // Check if the string is empty later
        return withContext(ioDispatcher) {
            repository.getWeatherForecast(location, noOfDays)
        }
    }
}