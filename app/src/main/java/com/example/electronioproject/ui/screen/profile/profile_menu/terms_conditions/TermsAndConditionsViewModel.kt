package com.example.electronioproject.ui.screen.profile.profile_menu.terms_conditions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TermsAndConditionsViewModel : ViewModel() {
    private fun getTermsAndConditions(): List<TermsAndConditionsModel> {
        return TermsAndConditionData.dataTermsAndConditions
    }

    private val _getTermsAndConditions = MutableStateFlow(getTermsAndConditions())

    val groupedTermsAndConditions: MutableStateFlow<List<TermsAndConditionsModel>> get() = _getTermsAndConditions
}