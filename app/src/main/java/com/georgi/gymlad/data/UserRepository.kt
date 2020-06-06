package com.georgi.gymlad.data

import android.content.SharedPreferences
import com.georgi.gymlad.ActivityLevel
import com.georgi.gymlad.Constants.UserSharedPreferences.ACTIVITY_LEVEL
import com.georgi.gymlad.Constants.UserSharedPreferences.IS_ONBOARDING_COMPLETED
import com.georgi.gymlad.Constants.UserSharedPreferences.USER_CREDENTIALS
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject constructor(@Named(USER_CREDENTIALS) private val sharedPreferences: SharedPreferences) {
    companion object {
        val DEFAULT_LEVEL: ActivityLevel = ActivityLevel.BEGINNER
    }

    var activityLevel: ActivityLevel
        get() {
            val activityLevel = sharedPreferences.getString(ACTIVITY_LEVEL, "")
            return if (activityLevel.isNullOrEmpty()) {
                DEFAULT_LEVEL
            } else {
                ActivityLevel.valueOf(activityLevel)
            }
        }
        set(value) {
            sharedPreferences.edit().putString(ACTIVITY_LEVEL, value.name).apply()
        }

    var isOnboardingCompleted: Boolean
        get() {
            return sharedPreferences.getBoolean(IS_ONBOARDING_COMPLETED, false)
        }
        set(value) {
            sharedPreferences.edit().putBoolean(IS_ONBOARDING_COMPLETED, value).apply()
        }
}