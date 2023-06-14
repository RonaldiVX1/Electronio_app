package com.example.electronioproject.ui.screen.article

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.data.api.ApiConfig
import com.example.electronioproject.data.response.article.Article
import com.example.electronioproject.data.response.article.ArticleResponse
import com.example.electronioproject.ui.screen.utils.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel: ViewModel() {

    val articleList = mutableStateListOf<Article>()
    val loadingState = MutableStateFlow(LoadingState.IDLE)

    fun getAllArticle() {
        viewModelScope.launch {
            val client = ApiConfig.getApiService().getArticle()
            try {
                loadingState.emit(LoadingState.LOADING)
                client.enqueue(object : Callback<ArticleResponse> {
                    override fun onResponse(
                        call: Call<ArticleResponse>,
                        response: Response<ArticleResponse>
                    ) {
                        val responseBody = response.body()
                        articleList.clear()
                        articleList.addAll(responseBody!!.listArticle)
                    }

                    override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
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