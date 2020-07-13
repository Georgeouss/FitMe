package com.georgi.gymlad.di

import androidx.lifecycle.ViewModel
import com.georgi.gymlad.viewmodel.SplashViewModel
import com.georgi.gymlad.viewmodel.onboarding.ActivityLevelViewModel
import com.georgi.gymlad.viewmodel.onboarding.GenderViewModel
import com.georgi.gymlad.viewmodel.onboarding.GoalViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun injectSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GenderViewModel::class)
    internal abstract fun injectGenderViewModel(viewModel: GenderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ActivityLevelViewModel::class)
    internal abstract fun injectActivityLevelViewModel(viewModel: ActivityLevelViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GoalViewModel::class)
    internal abstract fun injectGoalViewModel(viewModel: GoalViewModel): ViewModel
}