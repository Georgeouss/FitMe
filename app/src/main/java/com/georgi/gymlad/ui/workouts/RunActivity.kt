package com.georgi.gymlad.ui.workouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.georgi.gymlad.R
import com.georgi.gymlad.databinding.ActivityRunBinding
import com.georgi.gymlad.di.ViewModelFactory
import com.georgi.gymlad.util.getComponent
import com.georgi.gymlad.viewmodel.workouts.RunViewModel
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import javax.inject.Inject

@RuntimePermissions
class RunActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: RunViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        application.getComponent().inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[RunViewModel::class.java]


        val binding: ActivityRunBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_run)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.startEvent.observe(this, Observer {
            startWorkoutWithPermissionCheck()
        })
    }

    @NeedsPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
    fun startWorkout() {
        viewModel.start()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
}