package com.example.jetnews.features.news.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetnews.features.news.composables.AppBar
import com.example.jetnews.features.news.composables.NewsItem
import com.example.jetnews.features.news.viewmodels.NewsController


//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(modifier: Modifier) {
    val newsController = hiltViewModel<NewsController>()
    val pullRefreshState =
        rememberPullRefreshState(refreshing = newsController.isRefreshing.value, onRefresh = {
            newsController.onRefresh()
        })

    Column {
        AppBar()

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            newsController.spaceNews.value?.let {
                it.results?.let {
                    Box(
                        modifier = modifier.pullRefresh(pullRefreshState),
                        contentAlignment = Alignment.Center,
                    ) {

                        LazyColumn(
                            modifier = Modifier.padding(
                                top = 8.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 24.dp
                            )
                        ) {
                            items(it) { newsItem -> NewsItem(newsItemModel = newsItem) }
                        }
                        PullRefreshIndicator(
                            refreshing = newsController.isRefreshing.value,
                            state = pullRefreshState,
                            contentColor = Color.Black
                        )
                    }
                } ?: Text(text = "Error loading the news!")

            } ?: CircularProgressIndicator()
        }
    }
}
