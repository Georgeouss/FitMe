package com.georgi.gymlad.di

import com.georgi.gymlad.ui.SplashActivity
import com.georgi.gymlad.ui.onboarding.GenderFragment
import com.georgi.gymlad.ui.onboarding.OnboardingActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class,
        ViewModelFactoryModule::class,
        PreferencesModule::class]
)
interface AppComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(genderFragment: GenderFragment)
    fun inject(onboardingActivity: OnboardingActivity)
}