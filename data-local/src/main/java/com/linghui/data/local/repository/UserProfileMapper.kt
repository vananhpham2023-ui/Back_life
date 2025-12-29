package com.linghui.data.local.repository

import com.linghui.core.domain.model.UserProfile
import com.linghui.data.local.entity.UserProfileEntity

fun UserProfileEntity.toDomain(): UserProfile =
    UserProfile(
        id = id,
        nickname = nickname,
        tone = tone,
        focusGoalType = focusGoalType,
        blockers = blockers,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )

fun UserProfile.toEntity(): UserProfileEntity =
    UserProfileEntity(
        id = id,
        nickname = nickname,
        tone = tone,
        focusGoalType = focusGoalType,
        blockers = blockers,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
