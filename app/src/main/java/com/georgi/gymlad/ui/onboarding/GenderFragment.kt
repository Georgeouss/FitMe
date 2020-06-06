package com.georgi.gymlad.ui.onboarding

import androidx.lifecycle.ViewModelProvider
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.onboarding.GenderViewModel

class GenderFragment : OnboardingStepFragment<GenderViewModel>() {
    override fun injectFragment() {
        activity?.application?.getComponent()?.inject(this)
    }

    override fun injectViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory)[GenderViewModel::class.java]
    }
}