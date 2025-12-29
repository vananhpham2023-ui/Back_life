package com.linghui.feature.tasks

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class TasksUiState(
    val title: String = "Tasks",
)

@HiltViewModel
class TasksViewModel
    @Inject
    constructor() : ViewModel() {
        private val _uiState = MutableStateFlow(TasksUiState())
        val uiState: StateFlow<TasksUiState> = _uiState.asStateFlow()
    }
