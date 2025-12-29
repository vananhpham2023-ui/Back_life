package com.linghui.data.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.linghui.core.domain.repository.ProfileRepository
import com.linghui.core.domain.repository.SettingsRepository
import com.linghui.core.domain.result.AppLogger
import com.linghui.data.local.dao.UserProfileDao
import com.linghui.data.local.datastore.SettingsDataStore
import com.linghui.data.local.db.AppDatabase
import com.linghui.data.local.db.AppDatabaseMigrations
import com.linghui.data.local.repository.ProfileRepositoryImpl
import com.linghui.data.local.repository.SettingsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "linghui.db",
        )
            .addMigrations(*AppDatabaseMigrations.ALL)
            .build()
    }

    @Provides
    fun provideUserProfileDao(db: AppDatabase): UserProfileDao = db.userProfileDao()

    @Provides
    @Singleton
    fun providePreferencesDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { File(context.filesDir, "settings.preferences_pb") },
        )
    }

    @Provides
    fun provideSettingsDataStore(dataStore: DataStore<Preferences>): SettingsDataStore {
        return SettingsDataStore(dataStore)
    }

    @Provides
    fun provideProfileRepository(
        dao: UserProfileDao,
        logger: AppLogger,
    ): ProfileRepository {
        return ProfileRepositoryImpl(dao, logger)
    }

    @Provides
    fun provideSettingsRepository(
        dataStore: SettingsDataStore,
        logger: AppLogger,
    ): SettingsRepository {
        return SettingsRepositoryImpl(dataStore, logger)
    }
}
