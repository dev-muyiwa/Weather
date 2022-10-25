package com.devmuyiwa.weather.feature_weather.domain.model

interface UnitDependentHourlyForecast {
    val temperature: Double
    val windSpeed: Double
    val pressure: Double
    val precipitationVolume: Double
}