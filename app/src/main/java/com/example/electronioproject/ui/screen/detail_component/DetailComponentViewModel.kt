package com.example.electronioproject.ui.screen.detail_component


import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.data.api.ApiConfig
import com.example.electronioproject.data.response.component.Component
import com.example.electronioproject.data.response.component.ComponentByIdResponse
import com.example.electronioproject.ui.screen.utils.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailComponentViewModel(val componentId: Long) : ViewModel() {
    val loadingState = MutableStateFlow(LoadingState.IDLE)
    val component = MutableStateFlow<Component?>(null)


    fun getComponentById() {
        viewModelScope.launch {

            try {
                loadingState.emit(LoadingState.LOADING)
                val client = ApiConfig.getApiService().getComponentById(id = componentId)
                client.enqueue(object : Callback<ComponentByIdResponse> {
                    override fun onResponse(
                        call: Call<ComponentByIdResponse>,
                        response: Response<ComponentByIdResponse>
                    ) {
                        val responseBody = response.body()
                        component.value = responseBody!!.component
                    }

                    override fun onFailure(call: Call<ComponentByIdResponse>, t: Throwable) {
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

