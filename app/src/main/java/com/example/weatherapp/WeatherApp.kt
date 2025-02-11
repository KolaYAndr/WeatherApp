package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.data.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApp)
            modules(appModule)
        }
    }
}