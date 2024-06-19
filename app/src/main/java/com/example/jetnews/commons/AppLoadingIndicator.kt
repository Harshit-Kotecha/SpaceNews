package com.example.jetnews.commons

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppLoadingIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(color = Color.Black)
}