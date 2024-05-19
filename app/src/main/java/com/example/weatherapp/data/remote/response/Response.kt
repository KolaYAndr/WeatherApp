package com.example.weatherapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("daily")
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("current_units")
    val currentUnits: CurrentUnits,
    @SerializedName("current")
    val current: Current
)