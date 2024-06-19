package com.example.jetnews.features.news.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Launches(
   @SerializedName("launch_id") val launchId: String?,
    val provider: String?
) : Parcelable