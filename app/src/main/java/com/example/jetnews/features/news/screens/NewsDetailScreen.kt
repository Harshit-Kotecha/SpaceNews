package com.example.jetnews.features.news.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetnews.commons.AppNetWorkImage
import com.example.jetnews.features.news.composables.AppBar
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.ui.theme.Purple40

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier, navController: NavHostController,
    newsItemModel: NewsItemModel?,
) {
    newsItemModel?.let {
    Column {
        it.newsSite?.let { it1 -> AppBar(title = it1) }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            AppNetWorkImage(url = it.imageUrl, contentDescription = it.title)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it.title,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, modifier = modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it.summary,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
            Spacer(modifier = Modifier.height(48.dp))
            HorizontalDivider(thickness = 2.dp, modifier = modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Published at:",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Text(
                    text = it.publishedDate(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Purple40,
                    )
                )
            }
        }
    }
    } ?: Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "An error occurred",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}