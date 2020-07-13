package com.georgi.gymlad

import android.app.Application
import com.georgi.gymlad.di.AppComponent
import com.georgi.gymlad.di.DaggerAppComponent

class FitMeApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}