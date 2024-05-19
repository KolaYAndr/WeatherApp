package com.example.weatherapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun ForecastCurrentTime(modifier: Modifier = Modifier, data: Double) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top)
    ) {
        Text(text = stringResource(R.string.my_location), fontSize = 32.sp)
        Text(
            text = stringResource(id = R.string.weather_in_degrees, data.toInt()),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}