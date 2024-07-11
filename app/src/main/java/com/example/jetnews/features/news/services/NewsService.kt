package com.example.jetnews.features.news.services

import com.example.jetnews.features.news.models.SpaceNews
import com.example.jetnews.features.news.models.SpaceNewsParams
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsService {
    @GET("/v4/articles")
    suspend fun getNews(@QueryMap spaceNewsParams: Map<String, Int>): Response<SpaceNews>
}