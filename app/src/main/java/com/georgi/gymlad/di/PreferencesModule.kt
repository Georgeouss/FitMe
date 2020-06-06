package com.georgi.gymlad.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.georgi.gymlad.Constants.UserSharedPreferences.USER_CREDENTIALS
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class PreferencesModule {

    @Singleton
    @Provides
    @Named(USER_CREDENTIALS)
    fun provideUserRepository(application: Application): SharedPreferences {
        return application.getSharedPreferences(USER_CREDENTIALS, Context.MODE_PRIVATE)
    }
}