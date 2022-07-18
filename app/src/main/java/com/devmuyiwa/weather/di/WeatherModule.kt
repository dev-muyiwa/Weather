package com.devmuyiwa.weather.di

import com.devmuyiwa.weather.api.ConnectivityInterceptor
import com.devmuyiwa.weather.api.ConnectivityInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherModule {

    @Binds
    @Singleton
    abstract fun bindConnectivityInterceptor(
        interceptorImpl: ConnectivityInterceptorImpl,
    ): ConnectivityInterceptor
}