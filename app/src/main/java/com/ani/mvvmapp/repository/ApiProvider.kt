package com.ani.mvvmapp.repository

import com.ani.mvvmapp.repository.OkHttpClient.getKey
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    private val apiService: ApiService by lazy { loadRetrofit() }
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    /**
     * Create the Retrofit instance with okHttpClient
     * and load the API service call file
     */
    private fun loadRetrofit(): ApiService {
        val okHttpClient = getKey()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient).build()
        return retrofit.create(ApiService::class.java)
    }

    fun getRetrofitService(): ApiService {
        return apiService
    }
}