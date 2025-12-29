package com.linghui.core.domain.result

interface AppLogger {
    fun d(
        tag: String,
        message: String,
    )

    fun e(
        tag: String,
        message: String,
        throwable: Throwable? = null,
    )
}
