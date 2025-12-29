package com.linghui.core.domain.usecase

import com.linghui.core.domain.model.AppSettings
import com.linghui.core.domain.repository.SettingsRepository
import com.linghui.core.domain.result.AppResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class UpdateNotificationsEnabledUseCaseTest {
    @Test
    fun updatesRepositoryValue() =
        runTest {
            val repository = FakeSettingsRepository()
            val useCase = UpdateNotificationsEnabledUseCase(repository)

            useCase(true)

            assertEquals(true, repository.latestValue)
        }
}

private class FakeSettingsRepository : SettingsRepository {
    private val _settingsFlow = MutableStateFlow(AppSettings(notificationsEnabled = false))
    var latestValue: Boolean? = null
        private set

    override val settingsFlow: StateFlow<AppSettings> = _settingsFlow

    override suspend fun updateNotificationsEnabled(enabled: Boolean): AppResult<Unit> {
        latestValue = enabled
        _settingsFlow.value = AppSettings(notificationsEnabled = enabled)
        return AppResult.Success(Unit)
    }
}
