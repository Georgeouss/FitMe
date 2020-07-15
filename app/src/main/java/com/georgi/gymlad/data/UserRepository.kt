package com.georgi.gymlad.data

import android.content.SharedPreferences
import com.georgi.gymlad.ActivityLevel
import com.georgi.gymlad.Constants
import com.georgi.gymlad.Constants.UserSharedPreferences.ACTIVITY_LEVEL
import com.georgi.gymlad.Constants.UserSharedPreferences.GENDER
import com.georgi.gymlad.Constants.UserSharedPreferences.GOAL
import com.georgi.gymlad.Constants.UserSharedPreferences.USER_CREDENTIALS
import com.georgi.gymlad.Gender
import com.georgi.gymlad.Goal
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject constructor(@Named(USER_CREDENTIALS) private val sharedPreferences: SharedPreferences) {
    companion object {
        val DEFAULT_LEVEL: ActivityLevel = ActivityLevel.BEGINNER
    }

    var gender: Gender
        get() {
            val gender = sharedPreferences.getString(GENDER, "")
            return if (gender.isNullOrEmpty()) {
                Gender.MALE
            } else {
                Gender.valueOf(gender)
            }
        }
        set(value) {
            sharedPreferences.edit().putString(GENDER, value.name).apply()
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

    var goal: Goal
        get() {
            val goal = sharedPreferences.getString(GOAL, "")
            return if (goal.isNullOrEmpty()) {
                Goal.MAINTAIN_WEIGHT
            } else {
                Goal.valueOf(goal)
            }
        }
        set(value) {
            sharedPreferences.edit().putString(GOAL, value.name).apply()
        }

    var isOnboardingCompleted: Boolean
        get() {
            return sharedPreferences.getBoolean(
                Constants.UserSharedPreferences.IS_ONBOARDING_COMPLETED,
                false
            )
        }
        set(value) {
            sharedPreferences.edit()
                .putBoolean(Constants.UserSharedPreferences.IS_ONBOARDING_COMPLETED, value).apply()
        }
}