package com.example.weatherapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("interval")
    val interval: Int,
    @SerializedName("temperature_2m")
    val temperature: Double,
    @SerializedName("time")
    val time: String
)