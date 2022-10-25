package com.devmuyiwa.weather.feature_weather.di

import android.content.*
import androidx.room.*
import com.devmuyiwa.weather.feature_weather.data.local.*
import com.devmuyiwa.weather.feature_weather.data.util.*
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
	@Provides
	@Singleton
	fun provideWeatherDb(
		@ApplicationContext context: Context,
		moshi: Moshi
	): WeatherDb {
		return Room.databaseBuilder(
			context,
			WeatherDb::class.java,
			"weather_db"
		).addTypeConverter(Converters(MoshiParser(moshi)))
			.build()
	}

	@Provides
	@Singleton
	fun provideMoshi(): Moshi {
		return Moshi.Builder()
			.addLast(KotlinJsonAdapterFactory())
			.build()
	}
}