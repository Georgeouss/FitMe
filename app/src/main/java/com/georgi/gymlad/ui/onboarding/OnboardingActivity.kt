package com.georgi.gymlad.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.georgi.gymlad.R
import com.georgi.gymlad.di.ViewModelFactory
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.onboarding.OnboardingViewModel
import kotlinx.android.synthetic.main.activity_onboarding.*
import javax.inject.Inject

class OnboardingActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

//    private lateinit var viewModel: OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        application?.getComponent()?.inject(this)
        super.onCreate(savedInstanceState)

//            findNavController(R.id.nav_host_fragment).navigate(0)

    }
}