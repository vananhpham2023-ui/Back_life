package com.linghui.data.local.repository

import com.linghui.core.domain.model.AppSettings
import com.linghui.core.domain.repository.SettingsRepository
import com.linghui.core.domain.result.AppError
import com.linghui.core.domain.result.AppLogger
import com.linghui.core.domain.result.AppResult
import com.linghui.data.local.datastore.SettingsDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl
    @Inject
    constructor(
        private val dataStore: SettingsDataStore,
        private val logger: AppLogger,
    ) : SettingsRepository {
        override val settingsFlow: Flow<AppSettings> = dataStore.settingsFlow

        override suspend fun updateNotificationsEnabled(enabled: Boolean): AppResult<Unit> {
            return try {
                dataStore.updateNotificationsEnabled(enabled)
                AppResult.Success(Unit)
            } catch (throwable: Throwable) {
                logger.e("SettingsRepository", "Failed to update settings", throwable)
                AppResult.Error(AppError.Storage(throwable.message))
            }
        }
    }
