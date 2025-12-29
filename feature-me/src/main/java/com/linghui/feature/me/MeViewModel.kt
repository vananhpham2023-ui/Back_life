package com.linghui.feature.me

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linghui.core.domain.dispatcher.AppDispatchers
import com.linghui.core.domain.model.UserProfile
import com.linghui.core.domain.usecase.ObserveProfileUseCase
import com.linghui.core.domain.usecase.ObserveSettingsUseCase
import com.linghui.core.domain.usecase.SaveProfileUseCase
import com.linghui.core.domain.usecase.UpdateNotificationsEnabledUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MeUiState(
    val nickname: String = "Not set",
    val notificationsEnabled: Boolean = true,
)

@HiltViewModel
class MeViewModel
    @Inject
    constructor(
        observeProfileUseCase: ObserveProfileUseCase,
        observeSettingsUseCase: ObserveSettingsUseCase,
        private val saveProfileUseCase: SaveProfileUseCase,
        private val updateNotificationsEnabledUseCase: UpdateNotificationsEnabledUseCase,
        private val dispatchers: AppDispatchers,
    ) : ViewModel() {
        val uiState: StateFlow<MeUiState> =
            combine(
                observeProfileUseCase(),
                observeSettingsUseCase(),
            ) { profile, settings ->
                MeUiState(
                    nickname = profile?.nickname ?: "Not set",
                    notificationsEnabled = settings.notificationsEnabled,
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = MeUiState(),
            )

        fun writeSampleProfile() {
            viewModelScope.launch(dispatchers.io) {
                val now = System.currentTimeMillis()
                saveProfileUseCase(
                    UserProfile(
                        id = "local",
                        nickname = "Sample",
                        tone = "gentle",
                        focusGoalType = "study",
                        blockers = listOf("procrastination"),
                        createdAt = now,
                        updatedAt = now,
                    ),
                )
            }
        }

        fun toggleNotifications() {
            val nextValue = !uiState.value.notificationsEnabled
            viewModelScope.launch(dispatchers.io) {
                updateNotificationsEnabledUseCase(nextValue)
            }
        }
    }
