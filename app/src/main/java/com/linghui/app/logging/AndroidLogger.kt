package com.linghui.app.logging

import android.util.Log
import com.linghui.core.domain.result.AppLogger

class AndroidLogger : AppLogger {
    override fun d(
        tag: String,
        message: String,
    ) {
        Log.d(tag, message)
    }

    override fun e(
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        Log.e(tag, message, throwable)
    }
}
