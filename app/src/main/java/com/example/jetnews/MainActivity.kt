package com.example.jetnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.jetnews.features.news.navigation.AppNavHost
import com.example.jetnews.features.news.screens.HomeScreen
import com.example.jetnews.ui.theme.JetNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNewsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(navHostController = rememberNavController())
                }
            }
        }
    }
}
