package com.example.jetnews.features.news.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.jetnews.commons.AppPullRefreshIndicator
import com.example.jetnews.features.news.composables.AppBar
import com.example.jetnews.features.news.composables.NewsItem
import com.example.jetnews.features.news.viewmodels.NewsViewModel


//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val newsViewModel = hiltViewModel<NewsViewModel>()
    val pullRefreshState =
        rememberPullRefreshState(refreshing = newsViewModel.isRefreshing.value, onRefresh = {
            newsViewModel.onRefresh()
        })

    val articles = newsViewModel.getBreakingNews()
        .collectAsLazyPagingItems()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar()
        AppPullRefreshIndicator(
            pullRefreshState = pullRefreshState,
            isRefreshing = newsViewModel.isRefreshing.value
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyColumn(
                modifier = Modifier.padding(
                    start = 24.dp, end = 24.dp, bottom = 24.dp,
                )
            ) {
                items(articles.itemCount) {
                    val newsItem = articles[it]
                    newsItem?.let {
                        NewsItem(
                            newsItemModel = newsItem,
                            navController = navController,
                        )
                    }
                }
            }
        }
        //newsViewModel.spaceNews.value?.let {
        //    it.results?.let {
        //        Box(
        //            modifier = Modifier.pullRefresh(pullRefreshState),
        //            contentAlignment = Alignment.Center,
        //        ) {
        //            LazyColumn(
        //                modifier = Modifier.padding(
        //                    //top = 8.dp,
        //                    start = 24.dp, end = 24.dp, bottom = 24.dp,
        //                )
        //            ) {
        //                items(items = articles, key = { it }) {
        //                }
        //                //items(articles) { newsItem -> NewsItem(newsItemModel = newsItem,
        //                //    navController = navController,) }
        //            }
        //        }
        //    } ?: Text(text = "Error loading the news!")
        //
        //} ?: AppLoadingIndicator()
    }
}
