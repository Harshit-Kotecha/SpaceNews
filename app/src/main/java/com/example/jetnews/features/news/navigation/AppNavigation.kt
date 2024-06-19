package com.example.jetnews.features.news.navigation

enum class Screen {
    Home,
    NewsDetails,
}

sealed class NavigationItem(val route : String) {
    object Home : NavigationItem(Screen.Home.name)

    object NewsDetails : NavigationItem(Screen.NewsDetails.name)
}



