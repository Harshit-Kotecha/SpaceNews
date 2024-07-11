package com.example.jetnews.features.news.services

import android.graphics.pdf.PdfDocument.Page
import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject

class NewsRepo @Inject constructor(private val newsService: NewsService){
    fun getNews() = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            NewsPagingSource(newsService)
        }
    ).flow
}