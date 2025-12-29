package com.linghui.core.domain.usecase

import com.linghui.core.domain.model.AppSettings
import com.linghui.core.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveSettingsUseCase
    @Inject
    constructor(
        private val repository: SettingsRepository,
    ) {
        operator fun invoke(): Flow<AppSettings> = repository.settingsFlow
    }
