package com.example.weatherapp.presentation.screens.forecast_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.composables.ForecastFuture
import com.example.weatherapp.presentation.composables.ForecastCurrentTime

@Composable
fun ForecastScreen(
    modifier: Modifier = Modifier,
    uiState: ForecastUiState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is ForecastUiState.Error -> {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    text = uiState.errorMessage,
                    textAlign = TextAlign.Center
                )
            }

            is ForecastUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            is ForecastUiState.Weather -> {
                ForecastCurrentTime(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    data = uiState.currentTemperature
                )
                ForecastFuture(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    forecast = uiState.forecast
                )
            }
        }
    }
}


