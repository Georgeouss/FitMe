package com.georgi.gymlad.viewmodel

import androidx.lifecycle.ViewModel
import com.georgi.gymlad.data.SingleLiveEvent
import com.georgi.gymlad.data.UserRepository
import javax.inject.Inject

class SplashViewModel
@Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val startOnBoardingEvent = SingleLiveEvent<Unit>()
    val workoutScreen = SingleLiveEvent<Unit>()

    init {
        if (userRepository.isOnboardingCompleted) {
            workoutScreen.call()
        }
    }

    fun onButtonClick() {
        startOnBoardingEvent.call()
    }
}