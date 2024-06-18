package com.example.jetnews.features.news.services

import com.example.jetnews.features.news.models.SpaceNews
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("/v4/articles")
    suspend fun getAllNews(): Response<SpaceNews>
}