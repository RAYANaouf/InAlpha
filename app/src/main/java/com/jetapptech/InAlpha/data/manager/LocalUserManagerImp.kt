package com.jetapptech.InAlpha.data.manager

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.jetapptech.InAlpha.domain.manager.LocalUserManager
import com.jetapptech.InAlpha.util.dataStore.datastore_constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = datastore_constants.USER_SETTING)

class LocalUserManagerImp  constructor(
    private val context: Application
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {setting ->
            setting[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
         return context.dataStore.data.map {prefrences->
            prefrences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = datastore_constants.APP_ENTRY)
}