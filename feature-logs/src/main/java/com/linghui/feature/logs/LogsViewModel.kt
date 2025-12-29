package com.linghui.feature.logs

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class LogsUiState(
    val title: String = "Logs",
)

@HiltViewModel
class LogsViewModel
    @Inject
    constructor() : ViewModel() {
        private val _uiState = MutableStateFlow(LogsUiState())
        val uiState: StateFlow<LogsUiState> = _uiState.asStateFlow()
    }
