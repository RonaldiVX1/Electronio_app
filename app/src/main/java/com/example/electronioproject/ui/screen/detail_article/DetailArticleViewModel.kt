package com.example.electronioproject.ui.screen.detail_article

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.data.api.ApiConfig
import com.example.electronioproject.data.response.article.Article
import com.example.electronioproject.data.response.article.ArticleByIdResponse
import com.example.electronioproject.ui.screen.utils.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailArticleViewModel(val articleId: Long) : ViewModel() {
    val loadingState = MutableStateFlow(LoadingState.IDLE)
    val detailArticle = MutableStateFlow<Article?>(null)



    fun getArticleById() {
        viewModelScope.launch {

            try {
                loadingState.emit(LoadingState.LOADING)
                val client = ApiConfig.getApiService().getArticleById(id = articleId)
                client.enqueue(object : Callback<ArticleByIdResponse> {
                    override fun onResponse(
                        call: Call<ArticleByIdResponse>,
                        response: Response<ArticleByIdResponse>
                    ) {
                        val responseBody = response.body()
                        detailArticle.value = responseBody!!.article
                    }

                    override fun onFailure(call: Call<ArticleByIdResponse>, t: Throwable) {
                        Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                    }

                })
                loadingState.emit(LoadingState.SUCCESS)
            } catch (e: Exception) {
                loadingState.emit(LoadingState.error(e.message))
                Log.e(ContentValues.TAG, "onFailure: ${e.message}")
            }


        }

    }
}
