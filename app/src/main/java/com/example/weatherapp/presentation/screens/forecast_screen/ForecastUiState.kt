package com.example.weatherapp.presentation.screens.forecast_screen

import com.example.weatherapp.domain.model.WeatherData

sealed class ForecastUiState {
    data object Loading: ForecastUiState()
    data class Weather(val forecast: List<WeatherData>, val currentTemperature: Double) : ForecastUiState()
    data class Error(val errorMessage: String) : ForecastUiState()
}