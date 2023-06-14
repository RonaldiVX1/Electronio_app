package com.example.electronioproject.data.response.article

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("Url_Images")
    val url_images: String? = null,
) :Parcelable

