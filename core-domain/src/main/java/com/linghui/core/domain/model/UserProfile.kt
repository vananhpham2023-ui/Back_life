package com.linghui.core.domain.model

data class UserProfile(
    val id: String,
    val nickname: String?,
    val tone: String,
    val focusGoalType: String,
    val blockers: List<String>,
    val createdAt: Long,
    val updatedAt: Long,
)
