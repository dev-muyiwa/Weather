package com.devmuyiwa.weather.feature_weather.data.remote.util

import com.devmuyiwa.themovflix.feature_movies.data.remote.util.ConnectionManager
import com.devmuyiwa.weather.core.util.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkStatusInterceptor @Inject constructor(
    private val connectionManager: ConnectionManager,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (connectionManager.isConnected) {
            chain.proceed(chain.request())
        } else {
            throw NoConnectivityException()
        }
    }
}
