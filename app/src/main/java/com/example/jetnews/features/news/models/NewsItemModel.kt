package com.example.jetnews.features.news.models

import android.annotation.SuppressLint
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Parcelize
data class NewsItemModel(
    val events: List<Event>? = null,
    val featured: Boolean? = null,
    val id: Int? = null,
    val launches: List<Launches>? = null,
    val summary: String = "",
    val title: String = "",
    val url: String?,
    @SerializedName("published_at") private val publishedAt: String?,
    @SerializedName("news_site")   val newsSite: String?,
    @SerializedName("image_url") val imageUrl: String = "",
    @SerializedName("updated_at") private val updatedAt: String?,
) : Parcelable {

    fun publishedDate() : String {
        try {
            val formatter = DateTimeFormatter.ISO_DATE_TIME
            val time = LocalDateTime.parse(publishedAt, formatter)
            val formattedTime  = "${time.toLocalDate()} ${time.hour}:${time.minute}"
            return formattedTime
        } catch (e : Exception) {
            return ""
        }
    }
}