package com.devmuyiwa.weather.feature_weather.data.remote.mappers

import com.devmuyiwa.weather.feature_weather.data.local.entities.*
import com.devmuyiwa.weather.feature_weather.data.remote.forecastDto.*

fun RemoteWeatherForecastDto.toEntityModel(): LocalWeatherWithForecast {
    return LocalWeatherWithForecast(
        forecastId = 0,
        location = location!!.toEntityModel(),
        currentWeather = currentWeather!!.toEntityModel(),
        forecast = forecast?.forecast.orEmpty().map { it.toEntityModel() }
    )
}

fun RemoteLocation.toEntityModel(): LocalLocation {
    return LocalLocation(
        name = name.orEmpty(), region = region.orEmpty(), country = country.orEmpty(),
        latitude = latitude ?: 0.0, longitude = longitude ?: 0.0, tzId = tzId.orEmpty(),
        localtimeEpoch = localtimeEpoch ?: 0, localtime = localtime.orEmpty()
    )
}

fun RemoteCurrentWeather.toEntityModel(): LocalCurrentWeather {
    return LocalCurrentWeather(
        lastUpdatedEpoch = lastUpdatedEpoch ?: 0, tempInC = tempInC ?: 0.0,
        tempInF = tempInF ?: 0.0, isDay = isDay ?: 0, weatherText = condition?.text.orEmpty(),
        weatherIconUrl = condition?.icon.orEmpty(), weatherCode = condition?.code ?: 0,
        windMph = windMph ?: 0.0, windKph = windKph ?: 0.0, windDegree = windDegree ?: 0,
        windDirection = windDirection.orEmpty(), pressureMb = pressureMb ?: 0.0,
        pressureIn = pressureIn ?: 0.0, precipMm = precipMm ?: 0.0, precipIn = precipIn ?: 0.0,
        humidity = humidity ?: 0, cloud = cloud ?: 0, feelsLikeC = feelsLikeC ?: 0.0,
        feelsLikeF = feelsLikeF ?: 0.0, visKm = visKm ?: 0.0, visMiles = visMiles ?: 0.0,
        uv = uv ?: 0.0, gustMph = gustMph ?: 0.0, gustKph = gustKph ?: 0.0
    )
}

fun RemoteDailyForecast.toEntityModel(): LocalDailyForecast {
    return LocalDailyForecast(
        dateEpoch = dateEpoch ?: 0,
        astrology = astrology!!.toEntityModel(),
        day = day!!.toEntityModel(),
        hourlyForecast = hourlyForecast.orEmpty().map { it.toEntityModel() }
    )
}

fun RemoteAstrology.toEntityModel(): LocalAstrology {
    return LocalAstrology(
        sunrise = sunrise.orEmpty(), sunset = sunset.orEmpty()
    )
}

fun RemoteDay.toEntityModel(): LocalDay {
    return LocalDay(
        maxTempC = maxTempC ?: 0.0, maxTempF = maxTempF ?: 0.0, minTempC = minTempC ?: 0.0,
        minTempF = minTempF ?: 0.0, maxWindMph = maxWindMph ?: 0.0, maxWindKph = maxWindKph ?: 0.0,
        totalPrecipMm = totalPrecipMm ?: 0.0, totalPrecipIn = totalPrecipIn ?: 0.0,
        avgVisKm = avgVisKm ?: 0.0, avgVisMiles = avgVisMiles ?: 0.0, uv = uv ?: 0.0,
        averageHumidity = averageHumidity ?: 0.0
    )
}

fun RemoteHourlyForecast.toEntityModel(): LocalHourlyForecast {
    return LocalHourlyForecast(
        timeEpoch = timeEpoch ?: 0, time = time.orEmpty(), tempC = tempC ?: 0.0,
        tempF = tempF ?: 0.0, isDay = isDay ?: 0, weatherText = condition?.text.orEmpty(),
        weatherIconUrl = condition?.icon.orEmpty(), weatherCode = condition?.code ?: 0,
        windMph = windMph ?: 0.0, windKph = windKph ?: 0.0, windDegree = windDegree ?: 0,
        windDir = windDir.orEmpty(), pressureMb = pressureMb ?: 0.0, pressureIn = pressureIn ?: 0.0,
        precipMm = precipMm ?: 0.0, precipIn = precipIn ?: 0.0, humidity = humidity ?: 0,
        cloud = cloud ?: 0, feelsLikeC = feelsLikeC ?: 0.0, feelsLikeF = feelsLikeF ?: 0.0,
        visKm = visKm ?: 0.0, visMiles = visMiles ?: 0.0
    )
}

