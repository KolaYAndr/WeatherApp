package com.example.weatherapp.domain.usecase

import java.util.Locale
import android.icu.text.SimpleDateFormat
import com.example.weatherapp.data.remote.response.Response
import com.example.weatherapp.domain.model.WeatherData
import com.example.weatherapp.domain.model.WeatherType

class WeatherUseCase {
    companion object {
        fun parseWeatherData(response: Response): List<WeatherData> {
            val result = mutableListOf<WeatherData>()
            val serverFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val applicationFormatter = SimpleDateFormat("EEE", Locale.getDefault())
            response.daily.time.forEachIndexed { index, day ->
                val date = applicationFormatter.format(serverFormatter.parse(day))
                val code = response.daily.weatherCode[index]
                val weatherType = WeatherType.fromWeatherCode(code)
                val temperature = response.daily.temperatureMax[index]

                result.add(WeatherData(date.toString(), temperature.toInt(), weatherType))
            }

            return result
        }
    }
}