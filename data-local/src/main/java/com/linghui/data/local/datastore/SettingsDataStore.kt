package com.linghui.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.linghui.core.domain.model.AppSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsDataStore
    @Inject
    constructor(
        private val dataStore: DataStore<Preferences>,
    ) {
        private object Keys {
            val NOTIFICATIONS_ENABLED = booleanPreferencesKey("notifications_enabled")
        }

        val settingsFlow: Flow<AppSettings> =
            dataStore.data.map { prefs ->
                AppSettings(
                    notificationsEnabled = prefs[Keys.NOTIFICATIONS_ENABLED] ?: true,
                )
            }

        suspend fun updateNotificationsEnabled(enabled: Boolean) {
            dataStore.edit { prefs ->
                prefs[Keys.NOTIFICATIONS_ENABLED] = enabled
            }
        }
    }
