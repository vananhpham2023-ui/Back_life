package com.linghui.core.domain.result

sealed class AppError(
    open val message: String? = null,
) {
    data class Storage(override val message: String? = null) : AppError(message)

    data class NotFound(override val message: String? = null) : AppError(message)

    data class Unknown(override val message: String? = null) : AppError(message)
}
