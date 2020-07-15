package com.georgi.gymlad.util

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.georgi.gymlad.data.RunData
import com.google.android.gms.location.*
import io.reactivex.Observable
import javax.inject.Inject

class RxRunTracker @Inject constructor(private val application: Application) {
    companion object {
        const val DISPLACEMENT_IN_M = 10f
        const val MAX_WAIT_TIME_MILLIS = 10000L
        const val TIME_INTERVAL_MILLIS = 5000L
    }

    private var locationRequest: LocationRequest? = null
    private var fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    fun observe(): Observable<RunData> {
        if (ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            buildLocationRequest()
            var locationCallback: LocationCallback? = null
            var previousLocation: Location? = null

            val observable: Observable<RunData> = Observable.create { subscriber ->
                if (locationCallback == null) {
                    locationCallback = object : LocationCallback() {
                        override fun onLocationResult(locationResult: LocationResult) {
                            super.onLocationResult(locationResult)
                            locationResult.locations.forEach {
                                val distance = previousLocation?.distanceTo(it) ?: 0f
                                subscriber.onNext(RunData(distance, it.speed))
                                previousLocation = it
                            }
                        }
                    }

                    fusedLocationClient.requestLocationUpdates(
                        locationRequest,
                        locationCallback,
                        application.mainLooper
                    )
                }
            }
            return observable.doOnDispose {
                fusedLocationClient.removeLocationUpdates(locationCallback)
            }
        } else {
            return Observable.empty()
        }
    }

    private fun buildLocationRequest() {
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = TIME_INTERVAL_MILLIS
        locationRequest.smallestDisplacement = DISPLACEMENT_IN_M
        locationRequest.maxWaitTime = MAX_WAIT_TIME_MILLIS
        this.locationRequest = locationRequest
    }
}