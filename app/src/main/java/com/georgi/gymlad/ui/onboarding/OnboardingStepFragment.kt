package com.georgi.gymlad.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.georgi.gymlad.data.OnOnboardingOptionClick
import com.georgi.gymlad.databinding.FragmentOnboardingOptionsBinding
import com.georgi.gymlad.di.ViewModelFactory
import com.georgi.gymlad.ui.BaseFragment
import com.georgi.gymlad.viewmodel.onboarding.OnboardingStepViewModel
import javax.inject.Inject

abstract class OnboardingStepFragment<VM : OnboardingStepViewModel> :
    BaseFragment<FragmentOnboardingOptionsBinding>() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        injectFragment()
        super.onAttach(context)
    }

    abstract fun injectFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectViewModel()
    }

    abstract fun injectViewModel()

    override fun createBinding(
        inflater: LayoutInflater, parent: ViewGroup?
    ): FragmentOnboardingOptionsBinding {
        return FragmentOnboardingOptionsBinding.inflate(
            LayoutInflater.from(parent?.context),
            parent,
            false
        )
    }

    fun initOptions(onOnboardingOptionClick: OnOnboardingOptionClick) {
        val adapter = OptionsAdapter(viewModel.options, onOnboardingOptionClick, viewLifecycleOwner)
        val linearManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.let {
            it.viewModel = viewModel
            it.rcvOptions.apply {
                layoutManager = linearManager
                this.adapter = adapter
            }
        }
    }
}

