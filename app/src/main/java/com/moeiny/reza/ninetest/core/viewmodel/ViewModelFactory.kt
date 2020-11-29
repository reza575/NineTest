package com.moeiny.reza.ninetest.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moeiny.reza.ninetest.AndroidApplication
import com.moeiny.reza.ninetest.ui.news.NewsViewModel
import java.lang.IllegalArgumentException

/**
 * A  class that create a model class with base of NewsViewModel.
 */
class MyViewModelFactory(private val application: AndroidApplication) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass == NewsViewModel::class.java)
            NewsViewModel(application.newsRepository) as T
         else
            throw IllegalArgumentException()
    }
}
