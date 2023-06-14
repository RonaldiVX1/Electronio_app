package com.example.electronioproject.data.api

import com.example.electronioproject.data.response.article.ArticleByIdResponse
import com.example.electronioproject.data.response.article.ArticleResponse
import com.example.electronioproject.data.response.component.ComponentByIdResponse
import com.example.electronioproject.data.response.component.ComponentResponse
import com.example.electronioproject.data.response.scanner.ScannerResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("komponen")
    fun getComponent(
    ): Call<ComponentResponse>

    @GET("komponen/{id}")
    fun getComponentById(
        @Path("id") id : Long
    ): Call<ComponentByIdResponse>

    @GET("article")
    fun getArticle(
    ): Call<ArticleResponse>

    @GET("article/{id}")
    fun getArticleById(
        @Path("id") id : Long
    ): Call<ArticleByIdResponse>

    @Multipart
    @POST("predict")
    fun postScannerComponent(
        @Part file: MultipartBody.Part,
    ): Call<ScannerResponse>
}