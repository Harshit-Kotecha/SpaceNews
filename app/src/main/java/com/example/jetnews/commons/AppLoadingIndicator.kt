package com.example.jetnews.commons

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetnews.ui.theme.Primary

@Composable
fun AppLoadingIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(color = Primary)
}