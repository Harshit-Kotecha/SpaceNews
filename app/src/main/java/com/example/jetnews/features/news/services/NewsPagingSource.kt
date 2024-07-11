package com.example.jetnews.features.news.services

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.features.news.models.SpaceNewsParams

class NewsPagingSource(private val newsService: NewsService) : PagingSource<Int, NewsItemModel>() {
    override fun getRefreshKey(state: PagingState<Int, NewsItemModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(10)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(10)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItemModel> {
        return try {
            val offset = params.key ?: 0
            val spaceNewsParams = SpaceNewsParams(offset = offset)

            val map = mutableMapOf<String, Int>()
            map["limit"] = spaceNewsParams.limit
            map["offset"] = spaceNewsParams.offset

            val response = newsService.getNews(map)
            val articles = response.body()?.results ?: listOf()

            LoadResult.Page(
                data = articles,
                prevKey = if (offset == 0) null else offset.minus(10),
                nextKey = if (articles.isEmpty()) null else offset.plus(10)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}