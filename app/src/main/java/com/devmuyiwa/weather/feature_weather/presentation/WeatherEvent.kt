package com.devmuyiwa.weather.feature_weather.presentation

import java.text.FieldPosition

sealed class WeatherEvent {
    object DisplayWeeklyWeather: WeatherEvent()
}