package com.example.weatherapp.presentation.screens.forecast_screen

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.location.LocationTracker
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.usecase.WeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {
    private val _uiState: MutableStateFlow<ForecastUiState> =
        MutableStateFlow(ForecastUiState.Loading)
    val uiState: StateFlow<ForecastUiState> get() = _uiState

    fun getWeather() {
        val location = locationTracker.getLastLocationObservable()

        location.addOnSuccessListener { userLocation: Location? ->
            if (userLocation != null) {
                viewModelScope.launch {
                    try {
                        val response =
                            repository.getWeather(userLocation.latitude, userLocation.longitude)
                        val forecast = WeatherUseCase.parseWeatherData(response)
                        val currentTemperature = response.current.temperature
                        _uiState.value = ForecastUiState.Weather(forecast, currentTemperature)
                    } catch (e: Exception) {
                        _uiState.value = ForecastUiState.Error(e.message.toString())
                    }
                }
            } else _uiState.value =
                ForecastUiState.Error("Location is not found. Check location availability and reload app")
        }
    }
}