package com.example.electronioproject.data.response.article

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleResponse(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val listArticle: List<Article>
): Parcelable

