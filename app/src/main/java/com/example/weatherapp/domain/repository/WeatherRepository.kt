package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.remote.response.Response

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double) : Response
}