package com.example.weatherapp.domain.model

data class WeatherData (
    val day: String,
    val maxTemperature: Int,
    val weatherType: WeatherType
)