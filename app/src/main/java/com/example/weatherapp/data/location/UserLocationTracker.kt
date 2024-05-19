package com.example.weatherapp.data.location

import android.location.Location
import com.example.weatherapp.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task

class UserLocationTracker(
    private val locationClient: FusedLocationProviderClient
): LocationTracker {
    override fun getLastLocationObservable(): Task<Location> {
        return locationClient.lastLocation
    }
}