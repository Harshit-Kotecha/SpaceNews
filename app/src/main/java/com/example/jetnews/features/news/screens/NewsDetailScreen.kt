package com.example.jetnews.features.news.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetnews.R
import com.example.jetnews.commons.AppLoadingIndicator
import com.example.jetnews.commons.AppNetWorkImage
import com.example.jetnews.features.news.composables.AppBar
import com.example.jetnews.features.news.models.NewsItemModel
import com.example.jetnews.ui.theme.Primary
import com.example.jetnews.ui.theme.Purple40

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier, navController: NavHostController,
    newsItemModel: NewsItemModel?,
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(newsItemModel!!.url)) }

    newsItemModel?.let {
        Column  {
            it.newsSite?.let { it1 -> AppBar(title = it1) }
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
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
                        fontSize = 18.sp,
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
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    )
                    Text(
                        text = it.publishedDate(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Purple40,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        context.startActivity(intent)
                    },
                    colors = ButtonColors(
                        contentColor = Color.White,
                        containerColor = Primary,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.White,
                    ),
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Open news on web",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                            )
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.redirect_svgrepo_com),
                            contentDescription = "redirect icon",
                            tint = Color.White,
                            modifier = Modifier
                                .width(24.dp)
                        )
                    }
                }
            }
        }
    } ?: AppLoadingIndicator()
}