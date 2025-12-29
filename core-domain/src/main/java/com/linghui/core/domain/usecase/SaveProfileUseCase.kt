package com.linghui.core.domain.usecase

import com.linghui.core.domain.model.UserProfile
import com.linghui.core.domain.repository.ProfileRepository
import com.linghui.core.domain.result.AppResult
import javax.inject.Inject

class SaveProfileUseCase
    @Inject
    constructor(
        private val repository: ProfileRepository,
    ) {
        suspend operator fun invoke(profile: UserProfile): AppResult<Unit> {
            return repository.upsertProfile(profile)
        }
    }
