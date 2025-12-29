package com.linghui.feature.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.linghui.core.ui.components.PrimaryButton
import com.linghui.core.ui.theme.AppSpacing

@Composable
@Suppress("FunctionName")
fun TaskDetailRoute(
    taskId: String,
    onBack: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(AppSpacing.md),
    ) {
        Text(text = "Task detail: $taskId")
        PrimaryButton(
            text = "Back",
            onClick = onBack,
        )
    }
}
