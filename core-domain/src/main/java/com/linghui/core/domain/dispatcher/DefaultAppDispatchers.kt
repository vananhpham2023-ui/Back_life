package com.linghui.core.domain.dispatcher

import kotlinx.coroutines.Dispatchers

class DefaultAppDispatchers : AppDispatchers {
    override val io = Dispatchers.IO
    override val default = Dispatchers.Default
    override val main = Dispatchers.Main
}
