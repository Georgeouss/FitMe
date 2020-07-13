package com.georgi.gymlad.viewmodel

import androidx.lifecycle.ViewModel
import com.georgi.gymlad.data.SingleLiveEvent
import com.georgi.gymlad.data.UserRepository
import javax.inject.Inject

class SplashViewModel
@Inject constructor() : ViewModel() {

    val startOnBoardingEvent = SingleLiveEvent<Unit>()

    fun onButtonClick() {
        startOnBoardingEvent.call()
    }
}