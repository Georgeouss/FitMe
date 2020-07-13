package com.georgi.gymlad.ui.onboarding

import androidx.lifecycle.ViewModel
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.data.SingleLiveEvent

abstract class OnboardingStepViewModel : ViewModel() {

    val nextScreenEvent = SingleLiveEvent<Unit>()
    abstract val title: Int
    abstract val options: List<Option>
    abstract fun onOptionCLick(item: Any)
}