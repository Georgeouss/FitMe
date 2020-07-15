package com.georgi.gymlad.di

import android.app.Application
import com.georgi.gymlad.ui.SplashActivity
import com.georgi.gymlad.ui.onboarding.ActivityLevelFragment
import com.georgi.gymlad.ui.onboarding.GenderFragment
import com.georgi.gymlad.ui.onboarding.GoalFragment
import com.georgi.gymlad.ui.workouts.RunActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class,
        ViewModelFactoryModule::class,
        PreferencesModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(splashActivity: SplashActivity)
    fun inject(genderFragment: GenderFragment)
    fun inject(activityLevelFragment: ActivityLevelFragment)
    fun inject(goalFragment: GoalFragment)
    fun inject(runActivity: RunActivity)
}