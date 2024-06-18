package com.example.jetnews.features.news.models

import com.google.gson.annotations.SerializedName

data class Launches(
   @SerializedName("launch_id") val launchId: String?,
    val provider: String?
)