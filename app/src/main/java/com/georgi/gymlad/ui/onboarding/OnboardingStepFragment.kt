package com.georgi.gymlad.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.georgi.gymlad.databinding.FragmentOnboardingStepBinding
import com.georgi.gymlad.di.ViewModelFactory
import com.georgi.gymlad.ui.BaseFragment
import javax.inject.Inject

abstract class OnboardingStepFragment<VM : OnboardingStepViewModel> :
    BaseFragment<FragmentOnboardingStepBinding>() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        injectFragment()
        super.onAttach(context)
    }

    abstract fun injectFragment()
    abstract fun injectViewModel()

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): FragmentOnboardingStepBinding {
        return FragmentOnboardingStepBinding.inflate(
            LayoutInflater.from(parent?.context),
            parent,
            false
        )
    }

    override fun onViewCreated(
        binding: FragmentOnboardingStepBinding,
        savedInstanceState: Bundle?
    ) {
        binding.viewModel = viewModel
    }

}

