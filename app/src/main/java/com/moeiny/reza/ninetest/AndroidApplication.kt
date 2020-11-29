package com.moeiny.reza.ninetest

import android.app.Application
import com.moeiny.reza.ninetest.data.newsrepository.NewsRepository
import com.moeiny.reza.ninetest.data.newsrepository.NewsRepositoryDefault
import com.moeiny.reza.ninetest.data.retrofit.ApiService


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AndroidApplication: Application() {

    val newsRepository : NewsRepository by lazy {
        NewsRepositoryDefault(apiService)
    }

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    private val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://bruce-v2-mob.fairfaxmedia.com.au/1/coding_test/13ZZQX/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    override fun onCreate() {
        super.onCreate()

    }
}