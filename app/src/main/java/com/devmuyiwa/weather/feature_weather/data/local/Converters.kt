package com.devmuyiwa.weather.feature_weather.data.local

import androidx.room.*
import com.devmuyiwa.weather.feature_weather.data.local.entities.*
import com.devmuyiwa.weather.feature_weather.data.util.*
import com.squareup.moshi.*

@ProvidedTypeConverter
class Converters(
	private val jsonParser: JsonParser
) {
	@TypeConverter
	fun fromLocationJson(json: String): LocalLocation? {
		return jsonParser.fromJson<LocalLocation>(json, LocalLocation::class.java)
	}

	@TypeConverter
	fun toLocationJson(location: LocalLocation): String {
		return jsonParser.toJson(
			obj = location,
			type = LocalLocation::class.java
		) ?: ""
	}

	@TypeConverter
	fun fromCurrentJson(json: String): LocalCurrentWeather? {
		return jsonParser.fromJson<LocalCurrentWeather>(
			json = json,
			type = LocalCurrentWeather::class.java
		)
	}

	@TypeConverter
	fun toCurrentJson(currentWeather: LocalCurrentWeather): String {
		return jsonParser.toJson(
			obj = currentWeather,
			type = LocalCurrentWeather::class.java
		) ?: ""
	}

	@TypeConverter
	fun fromDailyForecastJson(json: String): List<LocalDailyForecast> {
		return jsonParser.fromJson<List<LocalDailyForecast>>(
			json = json,
			type = Types.newParameterizedType(List::class.java, LocalDailyForecast::class.java)
		) ?: emptyList()
	}

	@TypeConverter
	fun toDailyForecastJson(forecast: List<LocalDailyForecast>): String {
		return jsonParser.toJson(
			obj = forecast,
			type = Types.newParameterizedType(List::class.java, LocalDailyForecast::class.java)
		) ?: "[]"
	}
}