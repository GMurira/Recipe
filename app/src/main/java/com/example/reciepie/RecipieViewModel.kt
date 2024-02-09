package com.example.reciepie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class RecipieViewModel : ViewModel(){
    /**
     * Expose screen Ui State
     */
    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

     var serviceValue by mutableStateOf(0)
        private set
    /**
     * Handle business Logic
     */
    /**
     * Helper method to increase service value
     */
    fun increaseServiceValue(){
        serviceValue++
    }
    /**
     * Helper method to decrease service value
     */
    fun decreaseServiceValue(){
        if (serviceValue > 0)
            serviceValue --
    }
}