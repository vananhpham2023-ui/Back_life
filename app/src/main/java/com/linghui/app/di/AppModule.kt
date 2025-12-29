package com.linghui.app.di

import com.linghui.app.logging.AndroidLogger
import com.linghui.core.domain.dispatcher.AppDispatchers
import com.linghui.core.domain.dispatcher.DefaultAppDispatchers
import com.linghui.core.domain.result.AppLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDispatchers(): AppDispatchers = DefaultAppDispatchers()

    @Provides
    @Singleton
    fun provideLogger(): AppLogger = AndroidLogger()
}
