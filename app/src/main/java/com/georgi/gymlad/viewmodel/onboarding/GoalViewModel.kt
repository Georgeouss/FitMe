package com.georgi.gymlad.viewmodel.onboarding

import com.georgi.gymlad.Goal
import com.georgi.gymlad.R
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.data.UserRepository
import javax.inject.Inject

class GoalViewModel
@Inject constructor(private val userRepository: UserRepository) : OnboardingStepViewModel() {

    override val title: Int
        get() = R.string.onboarding_goal_title

    override val options
        get() = listOf(
            Option(R.drawable.ic_lose_weight, R.string.goal_lose_weight, Goal.LOSE_WEIGHT),
            Option(
                R.drawable.ic_maintain_weight,
                R.string.goal_maintain_weight,
                Goal.MAINTAIN_WEIGHT
            ),
            Option(R.drawable.ic_gain_weight, R.string.goal_gain_weight, Goal.GAIN_WEIGHT)
        )

    override fun onOptionCLick(item: Any) {
        userRepository.goal = item as? Goal ?: Goal.MAINTAIN_WEIGHT
        userRepository.isOnboardingCompleted = true
        nextScreenEvent.call()
    }
}