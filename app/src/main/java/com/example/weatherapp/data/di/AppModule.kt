package com.example.weatherapp.data.di

import com.example.weatherapp.data.location.UserLocationTracker
import com.example.weatherapp.data.remote.api.WeatherApi
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.presentation.screens.forecast_screen.ForecastViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_ENDPOINT = "https://api.open-meteo.com/"

val appModule = module {
    single<WeatherApi> {
        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherApi>())
    }

    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }

    single<UserLocationTracker> {
        UserLocationTracker(get<FusedLocationProviderClient>())
    }

    viewModel<ForecastViewModel> {
        ForecastViewModel(get<WeatherRepository>(), get<UserLocationTracker>())
    }
}