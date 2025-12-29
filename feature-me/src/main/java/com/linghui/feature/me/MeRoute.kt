package com.linghui.feature.me

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
fun MeRoute(viewModel: MeViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    MeScreen(
        state = state,
        onWriteProfile = viewModel::writeSampleProfile,
        onToggleNotifications = viewModel::toggleNotifications,
    )
}

@Composable
@Suppress("FunctionName")
private fun MeScreen(
    state: MeUiState,
    onWriteProfile: () -> Unit,
    onToggleNotifications: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(AppSpacing.md),
    ) {
        AppCard {
            Text(text = "Me")
            Text(text = "Nickname: ${state.nickname}")
            Text(text = "Notifications enabled: ${state.notificationsEnabled}")
            PrimaryButton(
                text = "Write sample profile",
                onClick = onWriteProfile,
            )
            PrimaryButton(
                text = "Toggle notifications",
                onClick = onToggleNotifications,
            )
        }
    }
}
