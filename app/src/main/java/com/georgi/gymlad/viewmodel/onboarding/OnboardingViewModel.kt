package com.georgi.gymlad.viewmodel.onboarding

import com.georgi.gymlad.data.SingleLiveEvent
import javax.inject.Inject

class OnboardingViewModel
@Inject constructor() {

    val nextScreen = SingleLiveEvent<Unit>()

}