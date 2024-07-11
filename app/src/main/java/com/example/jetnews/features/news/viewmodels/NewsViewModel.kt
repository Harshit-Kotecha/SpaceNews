package com.example.jetnews.features.news.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.features.news.models.SpaceNews
import com.example.jetnews.features.news.services.NewsPagingSource
import com.example.jetnews.features.news.services.NewsRepo
import com.example.jetnews.features.news.services.NewsService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {

    val isRefreshing = mutableStateOf(false)

    val spaceNews =
        mutableStateOf<SpaceNews?>(null)

    init {
        //getBreakingNews()
    }

    fun getBreakingNews()  = newsRepo.getNews().cachedIn(viewModelScope)

    //fun getNews() {
    //    viewModelScope.launch(Dispatchers.IO) {
    //
    //        val response = newsService.getNews()
    //        Log.d("API", "news are: $response")
    //        spaceNews.value = response.body()
    //    }
    //}

    fun onRefresh() {
        Log.d("home", "Refreshing the UI")
        isRefreshing.value = true
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            isRefreshing.value = false
        }
    }

}