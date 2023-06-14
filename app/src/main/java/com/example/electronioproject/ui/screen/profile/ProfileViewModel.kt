package com.example.electronioproject.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val loadingState = MutableStateFlow(LoadingState.IDLE)

    fun getUsername() : String? {
        val user = Firebase.auth.currentUser

        return user?.displayName
    }

    fun logOut() = viewModelScope.launch {
        try {
            loadingState.emit(LoadingState.LOADING)
            Firebase.auth.signOut()
            loadingState.emit(LoadingState.SUCCESS)
        } catch (e: Exception) {
            loadingState.emit(LoadingState.error(e.localizedMessage))
        }
    }
}