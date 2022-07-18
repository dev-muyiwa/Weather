package com.devmuyiwa.weather.di

import com.devmuyiwa.weather.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(interceptor: ConnectivityInterceptor): ApiService {
        return ApiClientInstance.invoke(interceptor)
    }
}