package com.example.weatherapp.domain.model

import androidx.annotation.DrawableRes
import com.example.weatherapp.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.sunny
    )

    data object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.partly_cloudy
    )

    data object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.partly_cloudy
    )

    data object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.cloudy
    )

    data object Foggy : WeatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.foggy
    )

    data object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.cloudy
    )

    data object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.heavy_rain
    )

    data object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.heavy_rain
    )

    data object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.heavy_rain
    )

    data object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.snowyrain
    )

    data object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.snowyrain
    )

    data object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.rainy
    )

    data object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.rainy
    )

    data object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.heavy_rain
    )

    data object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.snowyrain
    )

    data object SlightSnowFall : WeatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.snowy
    )

    data object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.heavy_snow
    )

    data object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.heavy_snow
    )

    data object SnowGrains : WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.heavy_snow
    )

    data object SlightRainShowers : WeatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.heavy_rain
    )

    data object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.heavy_rain
    )

    data object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.heavy_rain
    )

    data object SlightSnowShowers : WeatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.snowy
    )

    data object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.snowy
    )

    data object ModerateThunderstorm : WeatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.thunderstorm
    )

    data object SlightHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.thunderstorm
    )

    data object HeavyHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.thunderstorm
    )

    companion object {
        fun fromWeatherCode(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}