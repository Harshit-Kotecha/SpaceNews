package com.example.jetnews.features.news.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetnews.commons.AppNetWorkImage
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.features.news.navigation.NavigationItem
import com.example.jetnews.ui.theme.GameFont
import com.example.jetnews.ui.theme.Primary

//@Preview(showSystemUi = true)
@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    newsItemModel: NewsItemModel,
    navController: NavHostController,
) {
    Box(
        modifier = modifier
            .padding(top = 24.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("news", newsItemModel)

                navController.navigate(NavigationItem.NewsDetails.route)
            }
    ) {
        Column {
            AppNetWorkImage(
                url = newsItemModel.imageUrl,
                contentDescription = ""
            )

            Text(
                text = newsItemModel.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(vertical = 8.dp)

            )
            newsItemModel.newsSite?.let {
                Text(
                    text = newsItemModel.newsSite,
                    style = TextStyle(
                        fontFamily = GameFont,
                        fontSize = 14.sp,
                        color = Color.White,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Primary)
                        .padding(vertical = 6.dp, horizontal = 16.dp)
                )
            }
        }
    }
}