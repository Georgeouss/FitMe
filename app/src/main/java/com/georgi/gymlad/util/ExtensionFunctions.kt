package com.georgi.gymlad.util

import android.app.Application
import com.georgi.gymlad.FitMeApp
import com.georgi.gymlad.di.AppComponent

fun Application.getComponent(): AppComponent {
    return (this as FitMeApp).appComponent
}