package com.georgi.gymlad.di

import androidx.lifecycle.ViewModel
import com.georgi.gymlad.viewmodel.SplashViewModel
import com.georgi.gymlad.viewmodel.onboarding.GenderViewModel
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

}