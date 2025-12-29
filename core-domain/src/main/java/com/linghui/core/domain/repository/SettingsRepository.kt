package com.linghui.core.domain.repository

import com.linghui.core.domain.model.AppSettings
import com.linghui.core.domain.result.AppResult
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settingsFlow: Flow<AppSettings>

    suspend fun updateNotificationsEnabled(enabled: Boolean): AppResult<Unit>
}
