package com.example.arwa.weatherapp.weather_data.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    companion object {
        private const val CONTENT_TYPE = "Content-Type"
        private const val APPLICATION_JSON = "application/json"
        private const val ACCEPT = "Accept"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader(ACCEPT, APPLICATION_JSON)
                .build()
        )
    }
}