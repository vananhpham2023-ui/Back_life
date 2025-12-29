package com.linghui.core.domain.usecase

import com.linghui.core.domain.model.UserProfile
import com.linghui.core.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveProfileUseCase
    @Inject
    constructor(
        private val repository: ProfileRepository,
    ) {
        operator fun invoke(): Flow<UserProfile?> = repository.observeProfile()
    }
