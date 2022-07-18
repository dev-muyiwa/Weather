package com.devmuyiwa.weather.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.weatherapi.com/v1/forecast.json
// ?key=c260291158554336b7c70626222806&q=Nigeria&days=1&aqi=no&alerts=no
const val BASE_URL = "https://api.weatherapi.com/v1/"
const val API_KEY = "c260291158554336b7c70626222806"

class ApiClientInstance {
    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor,
        ): ApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}