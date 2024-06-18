package com.example.jetnews.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.jetnews.R

@Composable
fun NetWorkImage(url: String, contentDescription: String, onErrorDrawable: Int = R.drawable.space) {
    SubcomposeAsyncImage(
        model = url,
        //contentScale = ContentScale.FillWidth,
        contentDescription = contentDescription,
        loading = {
            Box(modifier = Modifier.fillMaxWidth().height(200.dp), Alignment.Center) {
                CircularProgressIndicator()
            }
        },
        error = {
            Image(
                painter = painterResource(onErrorDrawable),
                contentDescription = "Default space image"
            )
        },

    )
}