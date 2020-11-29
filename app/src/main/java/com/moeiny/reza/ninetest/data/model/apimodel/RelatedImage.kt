package com.moeiny.reza.ninetest.model

data class RelatedImage(
    val assetType: String,
    val authors: List<Author>,
    val brands: List<String>,
    val categories: List<Category>,
    val description: String,
    val height: Int,
    val id: Int,
    val large: String,
    val large2x: String,
    val lastModified: Long,
    val photographer: String,
    val sponsored: Boolean,
    val thumbnail: String,
    val thumbnail2x: String,
    val timeStamp: Long,
    val type: String,
    val url: String,
    val width: Int,
    val xLarge: String,
    val xLarge2x: String
)