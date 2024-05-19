package com.example.weatherapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weather_code")
    val weatherCode: List<Int>
)