package com.example.jetnews.features.news.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.features.news.screens.HomeScreen
import com.example.jetnews.features.news.screens.NewsDetailScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navHostController)
        }
        composable(route = NavigationItem.NewsDetails.route) {
            val newsItemModel =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<NewsItemModel>("news")

            NewsDetailScreen(navController = navHostController, newsItemModel = newsItemModel)
        }

    }
}