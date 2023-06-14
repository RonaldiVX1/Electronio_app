package com.example.electronioproject.data.response.component

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Component(

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("function")
    val function: String? = null,

    @field:SerializedName("Url_Images")
    val url_images: String? = null,
):Parcelable