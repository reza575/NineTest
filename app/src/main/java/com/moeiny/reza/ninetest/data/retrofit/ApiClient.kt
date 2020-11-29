package com.moeiny.reza.ninetest.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getClient():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://bruce-v2-mob.fairfaxmedia.com.au/1/coding_test/13ZZQX/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}