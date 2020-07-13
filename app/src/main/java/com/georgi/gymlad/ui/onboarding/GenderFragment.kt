package com.georgi.gymlad.ui.onboarding

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.georgi.gymlad.R
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.databinding.FragmentOnboardingOptionsBinding
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.onboarding.GenderViewModel

class GenderFragment : OnboardingStepFragment<GenderViewModel>(), OnOnboardingOptionClick {
    override fun injectFragment() {
        activity?.application?.getComponent()?.inject(this)
    }

    override fun injectViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[GenderViewModel::class.java]
    }

    override fun onOptionClick(option: Option) {
        viewModel.onOptionCLick(option)
    }

    override fun onViewCreated(
        binding: FragmentOnboardingOptionsBinding,
        savedInstanceState: Bundle?
    ) {
        initOptions(this)
        viewModel.nextScreenEvent.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_genderFragment_to_activityLevelFragment)
        })
    }
}