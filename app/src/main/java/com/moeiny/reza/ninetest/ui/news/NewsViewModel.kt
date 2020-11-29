package com.moeiny.reza.ninetest.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moeiny.reza.ninetest.core.result.Result
import com.moeiny.reza.ninetest.data.model.uimodel.ShowAssetModel
import com.moeiny.reza.ninetest.model.RelatedImage
import com.moeiny.reza.ninetest.data.newsrepository.NewsRepository
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow


class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val newsLiveData = MutableLiveData<List<ShowAssetModel>>()

    val loadingLiveData = MutableLiveData<Boolean>()

    val showNewsLiveData = MutableLiveData<String>()

     val errorLiveData = MutableLiveData<Boolean>()

    init {
        getAllNews()
    }

    /**
     * getAllNews function:fetching news data from repository by considering 3 state of onSuccess,onError,onLoading
     */

    fun getAllNews() {

     newsRepository.fetchNews { result ->
           if (result is Result.Success) {

               val assetList= result.data.assets.sortedByDescending { it.timeStamp }
               //Map News Data from API model to UI Model
               val showAssetList = assetList.map { asset ->
                   ShowAssetModel(
                       id = asset.id,
                       assetType = asset.assetType,
                       byLine = asset.byLine,
                       headline = asset.headline,
                       relatedImages = findSmallPhoto(asset.relatedImages),
                       theAbstract = asset.theAbstract,
                       timeStamp = getDate(asset.timeStamp),
                       url = asset.url
                   )
               }
               newsLiveData.postValue(showAssetList)
           } else if (result is Result.Loading){
               loadingLiveData.postValue(true)
           } else if (result is Result.Error){
               errorLiveData.postValue(true)
           }
       }
    }

    /**
     * getDate function: findSmallPhoto: find smallest photo between a list of photo by attention to height and width of photo
     * it assume that smallest photo is the photo with minimum diagonal
     */
    fun findSmallPhoto(imagList :List<RelatedImage>):String {
        return imagList.filterNot {
            it.height <= 0 || it.width <= 0
        }.minBy {
            it.width.toDouble().pow(2) + it.height.toDouble().pow(2)
        }?.url ?: ""
    }

    /**
     * getDate function: convert timestamp to  SimpleDateFormat
     */
    fun getDate(time: Long): String {
        val date = Date(time )
        val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss") // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+10"))

        return sdf.format(date)
    }

    fun onCardClicked(url: String) {
        showNewsLiveData.postValue(url)
    }

}