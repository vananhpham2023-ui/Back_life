package com.linghui.core.domain.repository

import com.linghui.core.domain.model.UserProfile
import com.linghui.core.domain.result.AppResult
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun observeProfile(): Flow<UserProfile?>

    suspend fun upsertProfile(profile: UserProfile): AppResult<Unit>
}
