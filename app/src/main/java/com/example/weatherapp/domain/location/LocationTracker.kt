package com.example.weatherapp.domain.location

import android.location.Location
import com.google.android.gms.tasks.Task


interface LocationTracker {
    fun getLastLocationObservable(): Task<Location>
}