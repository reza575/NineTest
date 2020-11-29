package com.moeiny.reza.ninetest.data.newsrepository

import com.moeiny.reza.ninetest.core.result.Result
import com.moeiny.reza.ninetest.data.retrofit.ApiService
import com.moeiny.reza.ninetest.model.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Class NewsRepositoryDefault trying to  receive data from Api nd this class has 3 state:
 * 1- Loading : When data started to load from API until loading completed.
 * 2- Response: Data has loaded completely without any error. this data deliver to App in this state.
 * 3- error: if any error happen during loading data this error will be handel by any predefined decision.
 */

class NewsRepositoryDefault( private val apiService: ApiService) : NewsRepository{
    override fun fetchNews( onResult: (result: Result<NewsModel>) -> Unit) {
        //TODO
        onResult(Result.Loading)
        //TODO
        apiService.getNewsInfo().enqueue(object :Callback<NewsModel>{
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                onResult(Result.Error(t))
            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                response.body()?.let {
                    onResult(Result.Success(it))
                }
            }
        })
    }
}

interface NewsRepository {
    fun fetchNews(onResult: (result: Result<NewsModel>) -> Unit)
}


