package com.example.jetnews.features.news.models

data class SpaceNews(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<NewsItemModel>?
)