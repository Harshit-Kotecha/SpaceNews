package com.example.jetnews.features.news.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Event(
   @SerializedName("event_id") val eventId: Int?,
    val provider: String
) : Parcelable