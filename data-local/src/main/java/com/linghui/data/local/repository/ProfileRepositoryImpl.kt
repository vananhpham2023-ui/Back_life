package com.linghui.data.local.repository

import com.linghui.core.domain.model.UserProfile
import com.linghui.core.domain.repository.ProfileRepository
import com.linghui.core.domain.result.AppError
import com.linghui.core.domain.result.AppLogger
import com.linghui.core.domain.result.AppResult
import com.linghui.data.local.dao.UserProfileDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProfileRepositoryImpl
    @Inject
    constructor(
        private val dao: UserProfileDao,
        private val logger: AppLogger,
    ) : ProfileRepository {
        override fun observeProfile(): Flow<UserProfile?> {
            return dao.observeProfile().map { entity -> entity?.toDomain() }
        }

        override suspend fun upsertProfile(profile: UserProfile): AppResult<Unit> {
            return try {
                dao.upsert(profile.toEntity())
                AppResult.Success(Unit)
            } catch (throwable: Throwable) {
                logger.e("ProfileRepository", "Failed to upsert profile", throwable)
                AppResult.Error(AppError.Storage(throwable.message))
            }
        }
    }
