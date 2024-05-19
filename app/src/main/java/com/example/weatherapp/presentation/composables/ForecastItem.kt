package com.example.weatherapp.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.WeatherData

@Composable
fun ForecastItem(modifier: Modifier = Modifier, data: WeatherData, name: String? = null) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(.3f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = (if (!name.isNullOrEmpty()) name else data.day).replaceFirstChar(Char::titlecase),
                fontSize = 30.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(
                    id = R.string.weather_in_degrees,
                    data.maxTemperature
                ),
                fontSize = 30.sp
            )
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = data.weatherType.iconRes),
                contentDescription = data.weatherType.weatherDesc
            )
        }
    }
}