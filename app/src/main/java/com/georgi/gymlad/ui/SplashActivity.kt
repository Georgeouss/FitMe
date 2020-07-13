package com.georgi.gymlad.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.georgi.gymlad.R
import com.georgi.gymlad.databinding.ActivitySplashBinding
import com.georgi.gymlad.di.ViewModelFactory
import com.georgi.gymlad.ui.onboarding.OnboardingActivity
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.SplashViewModel
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        application.getComponent().inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.viewModel = viewModel

        viewModel.startOnBoardingEvent.observe(this, Observer {
            val i = Intent(this, OnboardingActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        })
    }
}