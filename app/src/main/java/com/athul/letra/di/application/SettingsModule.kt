package com.athul.letra.di.application

import android.app.Application
import android.content.Context
import com.athul.letra.application.AppConstants
import com.athul.letra.ui.basecomponent.factories.SharedPrefsSettingsEntryFactory
import com.athul.letra.ui.basecomponent.managers.SettingsManager
import dagger.Module
import dagger.Provides

/**
 * Created by zco developer on 13-04-2018.
 */
@Module
class SettingsModule {


    @Provides
    @ApplicationScope
    fun provideSettingsManager(application: Application): SettingsManager {
        var sharedPreferences = application
                .getSharedPreferences(
                        AppConstants.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        return SettingsManager(SharedPrefsSettingsEntryFactory(sharedPreferences))

    }
}