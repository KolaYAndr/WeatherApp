package com.example.weatherapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class DailyUnits(
    @SerializedName("temperature_2m_max")
    val temperatureMax: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weather_code")
    val weatherCode: String
)