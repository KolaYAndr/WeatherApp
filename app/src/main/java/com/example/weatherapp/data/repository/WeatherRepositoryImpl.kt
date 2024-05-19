package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.api.WeatherApi
import com.example.weatherapp.data.remote.response.Response
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): Response =
        withContext(Dispatchers.IO) {
            api.getWeather(latitude = latitude, longitude = longitude)
        }
}
