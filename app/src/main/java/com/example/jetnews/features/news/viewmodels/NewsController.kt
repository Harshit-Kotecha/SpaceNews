package com.example.jetnews.features.news.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnews.features.news.models.SpaceNews
import com.example.jetnews.features.news.services.NewsService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsController @Inject constructor(private val newsService: NewsService) : ViewModel() {

    val isRefreshing = mutableStateOf(false)

    val spaceNews =
        mutableStateOf<SpaceNews?>(null)

    init {
        getAllNews()
    }

    private fun getAllNews() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = newsService.getAllNews()
            Log.d("API", "news are: $response")
            spaceNews.value = response.body()
        }
    }

    fun onRefresh() {
        Log.d("home", "Refreshing the UI")
        isRefreshing.value = true
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            getAllNews()
            isRefreshing.value = false
        }
    }

}