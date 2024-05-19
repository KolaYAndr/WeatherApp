package com.example.weatherapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.WeatherData

@Composable
fun ForecastFuture(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    forecast: List<WeatherData>
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        contentPadding = contentPadding
    ) {
        item {
            ForecastItem(
                modifier = Modifier.fillParentMaxWidth(),
                data = forecast.first(),
                name = stringResource(R.string.today)
            )
        }
        items(forecast.drop(1)) { day ->
            ForecastItem(
                modifier = Modifier.fillParentMaxWidth(),
                data = day
            )
        }
    }
}