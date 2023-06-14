package com.example.electronioproject.ui.screen.component

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.mutableStateListOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.data.api.ApiConfig
import com.example.electronioproject.data.response.component.Component
import com.example.electronioproject.data.response.component.ComponentResponse
import com.example.electronioproject.ui.screen.utils.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ComponentViewModel : ViewModel() {

    val componentList = mutableStateListOf<Component>()
    val homeSectionComponentList = mutableStateListOf<Component>()
    val loadingState = MutableStateFlow(LoadingState.IDLE)

    fun getAllComponent() {
        viewModelScope.launch {

            val client = ApiConfig.getApiService().getComponent()
            try {
                loadingState.emit(LoadingState.LOADING)
                client.enqueue(object : Callback<ComponentResponse> {
                    override fun onResponse(
                        call: Call<ComponentResponse>,
                        response: Response<ComponentResponse>
                    ) {

                        val responseBody = response.body()
                        componentList.clear()
                        componentList.addAll(responseBody!!.listComponent)
                        homeSectionComponentList.clear()
                        homeSectionComponentList.add(responseBody.listComponent[1])
                        homeSectionComponentList.add(responseBody.listComponent[2])

                    }

                    override fun onFailure(call: Call<ComponentResponse>, t: Throwable) {
                        Log.e(ContentValues.TAG, "onFailure: ${t.message}")

                    }

                })

            } catch (e: Exception) {
                loadingState.emit(LoadingState.error(e.message))
                Log.e(ContentValues.TAG, "onFailure: ${e.message}")
            }
            loadingState.emit(LoadingState.SUCCESS)
        }


    }

}