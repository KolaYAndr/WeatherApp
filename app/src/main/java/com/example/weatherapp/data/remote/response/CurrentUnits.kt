package com.example.weatherapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentUnits(
    @SerializedName("interval")
    val interval: String,
    @SerializedName("temperature_2m")
    val temperature: String,
    @SerializedName("time")
    val time: String
)