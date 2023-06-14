package com.example.electronioproject.ui.screen.scanner

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.data.api.ApiConfigScanner
import com.example.electronioproject.data.response.scanner.ScannerResponse
import com.example.electronioproject.ui.screen.utils.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScannerViewModel: ViewModel() {

    val loadingState = MutableStateFlow(LoadingState.IDLE)
    val scannerComponent = MutableStateFlow<ScannerResponse?>(null)

    fun scanComponent(imageMultipartBody: MultipartBody.Part) = viewModelScope.launch{
        try {
            loadingState.emit(LoadingState.LOADING)
            val client = ApiConfigScanner.getApiService().postScannerComponent(imageMultipartBody)
            client.enqueue(object : Callback<ScannerResponse>{
                override fun onResponse(
                    call: Call<ScannerResponse>,
                    response: Response<ScannerResponse>
                ) {
                    val responseBody = response.body()
                    scannerComponent.value = responseBody

                }

                override fun onFailure(call: Call<ScannerResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                }
            })
            loadingState.emit(LoadingState.SUCCESS)
        }catch (e: Exception){
            loadingState.emit(LoadingState.error(e.message))
        }
    }
}