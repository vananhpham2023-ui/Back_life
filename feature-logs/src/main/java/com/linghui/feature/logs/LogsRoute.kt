package com.linghui.feature.logs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.linghui.core.ui.components.AppCard
import com.linghui.core.ui.theme.AppSpacing

@Composable
@Suppress("FunctionName")
fun LogsRoute(viewModel: LogsViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LogsScreen(state)
}

@Composable
@Suppress("FunctionName")
private fun LogsScreen(state: LogsUiState) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(AppSpacing.md),
    ) {
        AppCard {
            Text(text = state.title)
            Text(text = "Sprint 0 shell for Logs.")
        }
    }
}
