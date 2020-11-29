package com.moeiny.reza.ninetest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moeiny.reza.ninetest.data.model.uimodel.ShowAssetModel
import com.moeiny.reza.ninetest.databinding.NewsBinding

class NewsAdapter(private val onCardClicked: (url: String) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.AssetViewHolder>() {

    var assetModelList: List<ShowAssetModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsBinding = NewsBinding.inflate(layoutInflater, parent, false)

        return AssetViewHolder(newsBinding)
    }

    override fun getItemCount(): Int {
        return assetModelList.count()
    }

    override fun onBindViewHolder(holderAsset: AssetViewHolder, position: Int) {
        var asset = assetModelList.get(position)
        holderAsset.newsBinding.cardNewsrowParent.setOnClickListener {
            onCardClicked(asset.url)
        }

        holderAsset.bind(asset)
    }

    inner class AssetViewHolder(val newsBinding: NewsBinding) :
        RecyclerView.ViewHolder(newsBinding.root) {
        fun bind(modelView: ShowAssetModel) {
            this.newsBinding.showAsset = modelView
        }
    }

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        Glide.with(context).load(url).into(this)
    }
}