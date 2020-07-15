package com.georgi.gymlad.viewmodel.onboarding

import com.georgi.gymlad.Gender
import com.georgi.gymlad.R
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.data.UserRepository
import javax.inject.Inject

class GenderViewModel
@Inject constructor(private val userRepository: UserRepository) : OnboardingStepViewModel() {

    override val title: Int
        get() = R.string.onboarding_gender_title

    override val options
        get() = listOf(
            Option(R.drawable.ic_male, R.string.male_label, Gender.MALE),
            Option(R.drawable.ic_female, R.string.female_label, Gender.FEMALE)
        )

    override fun onOptionCLick(item: Any) {
        userRepository.gender = item as? Gender ?: Gender.MALE
        nextScreenEvent.call()
    }
}