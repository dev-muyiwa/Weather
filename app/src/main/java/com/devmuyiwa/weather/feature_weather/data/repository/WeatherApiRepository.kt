package com.devmuyiwa.weather.feature_weather.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.devmuyiwa.weather.core.util.Resource
import com.devmuyiwa.weather.feature_weather.data.local.dao.ForecastDao
import com.devmuyiwa.weather.feature_weather.data.local.mappers.toDomainModel
import com.devmuyiwa.weather.feature_weather.data.remote.WeatherApi
import com.devmuyiwa.weather.feature_weather.data.remote.mappers.toEntityModel
import com.devmuyiwa.weather.feature_weather.domain.model.WeatherForecast
import com.devmuyiwa.weather.feature_weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherApiRepository @Inject constructor(
    private val api: WeatherApi,
    private val dao: ForecastDao
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getWeatherForecast(
        location: String,
        noOfDays: Int
    ): Flow<Resource<WeatherForecast>> {
        return flow {
            emit(Resource.Loading())
            val weatherForecast: WeatherForecast? = dao.getWeeklyForecast(location)?.let {
                /** Added the null check since a null value can't be mapped to a domain model or the app crashes. */
                it.toDomainModel()
            }
            emit(Resource.Loading(weatherForecast))
            try {
                val remoteWeatherForecast = api.getWeatherForecastData(location, noOfDays)
                dao.deleteWeeklyForecastByLocation(remoteWeatherForecast.location?.name.orEmpty())
                dao.insertWeeklyForecast(remoteWeatherForecast.toEntityModel())
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = e.localizedMessage ?: "Oops, something went wrong!",
                        data = weatherForecast
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = "Unable to reach server, Check your internet connection.",
                        data = weatherForecast
                    )
                )
            }
            val newWeatherForecast = dao.getWeeklyForecast(location).toDomainModel()
            emit(Resource.Success(newWeatherForecast))
        }
    }

}