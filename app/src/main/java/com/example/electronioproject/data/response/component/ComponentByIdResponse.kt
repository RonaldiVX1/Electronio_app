package com.example.electronioproject.data.response.component

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComponentByIdResponse(

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val component: Component

): Parcelable