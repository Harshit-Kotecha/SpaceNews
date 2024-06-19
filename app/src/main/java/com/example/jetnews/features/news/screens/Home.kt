package com.example.jetnews.features.news.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetnews.commons.AppLoadingIndicator
import com.example.jetnews.commons.AppPullRefreshIndicator
import com.example.jetnews.features.news.composables.AppBar
import com.example.jetnews.features.news.composables.NewsItem
import com.example.jetnews.features.news.viewmodels.NewsController


//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(paddingValues: PaddingValues) {
    val newsController = hiltViewModel<NewsController>()
    val pullRefreshState =
        rememberPullRefreshState(refreshing = newsController.isRefreshing.value, onRefresh = {
            newsController.onRefresh()
        })

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar()
        AppPullRefreshIndicator(
            pullRefreshState = pullRefreshState,
            isRefreshing = newsController.isRefreshing.value
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            newsController.spaceNews.value?.let {
                it.results?.let {
                    Box(
                        modifier = Modifier.pullRefresh(pullRefreshState),
                        contentAlignment = Alignment.Center,
                    ) {
                        LazyColumn(
                            modifier = Modifier.padding(
                                //top = 8.dp,
                                start = 24.dp, end = 24.dp, bottom = 24.dp,
                            )
                        ) {
                            items(it) { newsItem -> NewsItem(newsItemModel = newsItem) }
                        }
                    }
                } ?: Text(text = "Error loading the news!")

            } ?: AppLoadingIndicator()
        }
    }
}
