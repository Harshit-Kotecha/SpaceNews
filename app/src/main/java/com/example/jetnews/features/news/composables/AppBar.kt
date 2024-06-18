package com.example.jetnews.features.news.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnews.ui.theme.GameFont

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Text(
        "Space News",
        style = TextStyle(
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = GameFont,
            letterSpacing = 4.sp,
        ),
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(vertical = 12.dp)
    )
}