package com.linghui.core.domain.usecase

import com.linghui.core.domain.repository.SettingsRepository
import com.linghui.core.domain.result.AppResult
import javax.inject.Inject

class UpdateNotificationsEnabledUseCase
    @Inject
    constructor(
        private val repository: SettingsRepository,
    ) {
        suspend operator fun invoke(enabled: Boolean): AppResult<Unit> {
            return repository.updateNotificationsEnabled(enabled)
        }
    }
