package com.georgi.gymlad.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.data.Option
import com.georgi.gymlad.databinding.FragmentOnboardingOptionsBinding
import com.georgi.gymlad.ui.workouts.RunActivity
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.onboarding.GoalViewModel

class GoalFragment : OnboardingStepFragment<GoalViewModel>(), OnOnboardingOptionClick {
    override fun injectFragment() {
        activity?.application?.getComponent()?.inject(this)
    }

    override fun injectViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[GoalViewModel::class.java]
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
            val intent = Intent(context, RunActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
    }
}