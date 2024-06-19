package com.example.jetnews.commons

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppPullRefreshIndicator(
    modifier: Modifier = Modifier, pullRefreshState: PullRefreshState,
    isRefreshing: Boolean,
) {
    PullRefreshIndicator(
        refreshing = isRefreshing,
        state = pullRefreshState,
        contentColor = if (isRefreshing) Color.Black else Color.Transparent,
    )
}