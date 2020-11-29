package com.moeiny.reza.ninetest.data.retrofit


import com.moeiny.reza.ninetest.model.NewsModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("full")
    // Communicates responses from a server are executed on the background thread which performed the request
    fun getNewsInfo(): Call<NewsModel>
}