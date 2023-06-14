package com.example.electronioproject.ui.screen.profile.profile_menu.privacy_policy

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PrivacyAndPolicyViewModel : ViewModel() {
    private fun getPrivacyAndPolicy(): List<PrivacyAndPolicyModel> {
        return PrivacyAndPolicyData.dataPrivacyAndPolicy
    }

    private val _getPrivacyAndPolicy = MutableStateFlow(getPrivacyAndPolicy())

    val groupedPrivacyAndPolicy: MutableStateFlow<List<PrivacyAndPolicyModel>> get() = _getPrivacyAndPolicy
}