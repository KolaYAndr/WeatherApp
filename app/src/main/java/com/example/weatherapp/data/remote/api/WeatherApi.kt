package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?&daily=weather_code,temperature_2m_max&current=temperature_2m")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ) : Response
}