package com.linghui.feature.tasks

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
import com.linghui.core.ui.components.PrimaryButton
import com.linghui.core.ui.theme.AppSpacing

@Composable
@Suppress("FunctionName")
fun TasksRoute(
    onNavigateToDetail: (String) -> Unit,
    viewModel: TasksViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    TasksScreen(
        state = state,
        onNavigateToDetail = onNavigateToDetail,
    )
}

@Composable
@Suppress("FunctionName")
private fun TasksScreen(
    state: TasksUiState,
    onNavigateToDetail: (String) -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(AppSpacing.md),
    ) {
        AppCard {
            Text(text = state.title)
            Text(text = "Sprint 0 shell for Tasks.")
            PrimaryButton(
                text = "Open sample detail",
                onClick = { onNavigateToDetail("demo-task") },
            )
        }
    }
}
