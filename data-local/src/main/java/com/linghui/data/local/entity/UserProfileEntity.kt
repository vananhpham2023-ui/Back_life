package com.linghui.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: String,
    val nickname: String?,
    val tone: String,
    val focusGoalType: String,
    val blockers: List<String>,
    val createdAt: Long,
    val updatedAt: Long,
)
