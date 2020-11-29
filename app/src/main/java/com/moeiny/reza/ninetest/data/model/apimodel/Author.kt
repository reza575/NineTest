package com.moeiny.reza.ninetest.model

data class Author(
    val email: String,
    val name: String,
    val relatedAssets: List<Asset>,
    val relatedImages: List<RelatedImage>,
    val title: String
)