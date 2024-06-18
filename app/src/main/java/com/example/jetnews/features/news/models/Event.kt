package com.example.jetnews.features.news.models

import com.google.gson.annotations.SerializedName

data class Event(
   @SerializedName("event_id") val eventId: Int?,
    val provider: String
)