package com.moeiny.reza.ninetest.model


data class Asset(
    val acceptComments: Boolean,
    val assetType: String,
    val authors: List<Author>,
    val byLine: String,
    val categories: List<Category>,
    val companies: List<Company>,
    val headline: String,
    val id: Int,
    val indexHeadline: String,
    val lastModified: Long,
    val legalStatus: String,
    val numberOfComments: Int,
    val onTime: Long,
    val overrides: Overrides,
    val relatedAssets: List<Asset>,
    val relatedImages: List<RelatedImage>,
    val signPost: String?,
    val sources: List<Source>,
    val sponsored: Boolean,
    val tabletHeadline: String?,
    val theAbstract: String,
    val timeStamp: Long,
    val url: String
)