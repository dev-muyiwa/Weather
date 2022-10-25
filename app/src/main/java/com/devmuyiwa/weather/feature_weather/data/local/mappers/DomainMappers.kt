package com.devmuyiwa.weather.feature_weather.data.local.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.devmuyiwa.weather.feature_weather.data.local.entities.*
import com.devmuyiwa.weather.feature_weather.domain.model.*
import com.devmuyiwa.weather.feature_weather.util.toLocalDate
import com.devmuyiwa.weather.feature_weather.util.toLocalDateTime
import com.devmuyiwa.weather.feature_weather.util.toLocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun LocalWeatherWithForecast.toDomainModel(): WeatherForecast {
    return WeatherForecast(
        location = location.toDomainModel(),
        currentWeather = currentWeather.toDomainModel(),
        forecast = forecast.map { it.toDomainModel() }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalLocation.toDomainModel(): Location {
    return Location(
        name = name, region = region, country = country, latitude = latitude, tzId = tzId,
        longitude = longitude, localDateTime = localtimeEpoch.toLocalDateTime(),
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalCurrentWeather.toDomainModel(): CurrentWeather {
    return CurrentWeather(
        lastUpdated = lastUpdatedEpoch.toLocalDateTime(), tempInC = tempInC, tempInF = tempInF,
        isDay = isDay, weatherText = weatherText, weatherIconUrl = weatherIconUrl,
        weatherCode = weatherCode, windMph = windMph, windKph = windKph, windDegree = windDegree,
        windDirection = windDirection, pressureMb = pressureMb, pressureIn = pressureIn,
        precipMm = precipMm, precipIn = precipIn, humidity = humidity, cloud = cloud,
        feelsLikeC = feelsLikeC, feelsLikeF = feelsLikeF, visKm = visKm, visMiles = visMiles,
        uv = uv, gustMph = gustMph, gustKph = gustKph
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDailyForecast.toDomainModel(): DailyForecast {
    return DailyForecast(
        date = dateEpoch.toLocalDate(),
        day = day.toDomainModel(),
        astrology = astrology.toDomainModel(),
        hourlyForecast = hourlyForecast.map { hourlyForecast ->
            hourlyForecast.toDomainModel()
        }
    )
}

fun LocalDay.toDomainModel(): Day {
    return Day(
        maxTempC = maxTempC, maxTempF = maxTempF, minTempC = minTempC,
        minTempF = minTempF, maxWindKph = maxWindKph, maxWindMph = maxWindMph,
        totalPrecipMm = totalPrecipMm, totalPrecipIn = totalPrecipIn,
        avgVisKm = avgVisKm, avgVisMiles = avgVisMiles,
        averageHumidity = averageHumidity, uv = uv
    )
}

fun LocalAstrology.toDomainModel(): Astrology {
    return Astrology(
        sunrise = sunrise, sunset = sunset
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalHourlyForecast.toDomainModel(): HourlyForecast {
    return HourlyForecast(
        timeEpoch = timeEpoch.toLocalTime(), tempC = tempC, tempF = tempF, isDay = isDay,
        weatherText = weatherText, weatherIconUrl = "https:$weatherIconUrl",
        weatherCode = weatherCode, windMph = windMph, windKph = windKph, windDegree = windDegree,
        windDir = windDir, pressureMb = pressureMb, pressureIn = pressureIn, precipMm = precipMm,
        precipIn = precipIn, humidity = humidity, cloud = cloud, feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF, visKm = visKm, visMiles = visMiles
    )
}