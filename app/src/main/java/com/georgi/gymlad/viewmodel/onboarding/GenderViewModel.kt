package com.georgi.gymlad.viewmodel.onboarding

import com.georgi.gymlad.R
import com.georgi.gymlad.ui.onboarding.OnboardingStepViewModel
import javax.inject.Inject

class GenderViewModel
@Inject constructor() : OnboardingStepViewModel() {

    override val titleId
        get() = R.string.onboarding_gender_title
}