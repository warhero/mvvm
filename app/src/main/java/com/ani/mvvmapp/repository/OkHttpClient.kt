package com.ani.mvvmapp.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClient {
    private val okHttp by lazy {
        getClient()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    fun getKey(): OkHttpClient {
        return okHttp
    }

}