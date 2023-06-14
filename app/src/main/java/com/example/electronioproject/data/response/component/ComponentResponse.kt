package com.example.electronioproject.data.response.component

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComponentResponse(

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val listComponent: List<Component>

):Parcelable
