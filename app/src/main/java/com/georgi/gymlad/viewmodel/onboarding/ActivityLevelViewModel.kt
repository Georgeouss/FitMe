package com.georgi.gymlad.viewmodel.onboarding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.georgi.gymlad.ActivityLevel
import com.georgi.gymlad.R
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.data.UserRepository
import com.georgi.gymlad.ui.onboarding.OnboardingStepViewModel
import javax.inject.Inject

class ActivityLevelViewModel
@Inject constructor(private val userRepository: UserRepository) : OnboardingStepViewModel() {

    override val title: Int
        get() {
            return R.string.onboarding_activity_level_title
        }


    override val options
        get() = listOf(
            Option(R.drawable.ic_beginner, R.string.beginner_label, ActivityLevel.BEGINNER),
            Option(
                R.drawable.ic_intermediate,
                R.string.intermediate_label,
                ActivityLevel.INTERMEDIATE
            ),
            Option(R.drawable.ic_advanced, R.string.advanced_label, ActivityLevel.ADVANCED)
        )

    override fun onOptionCLick(item: Any) {
        userRepository.activityLevel = item as? ActivityLevel ?: ActivityLevel.BEGINNER
        nextScreenEvent.call()
    }
}