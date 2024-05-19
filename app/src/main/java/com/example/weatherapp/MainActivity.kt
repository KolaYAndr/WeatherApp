package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weatherapp.presentation.screens.forecast_screen.ForecastScreen
import com.example.weatherapp.presentation.screens.forecast_screen.ForecastViewModel
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = getViewModel<ForecastViewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                val launcher =
                    rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { permissionMap ->
                        if (permissionMap.any { it.value }) {
                            viewModel.getWeather()
                            Log.d("Ebal mamu", "tvoyu")
                        } else {
                            Log.d("Ne ebal mamu", "tvoyu")
                            Toast.makeText(
                                this,
                                "Unable to function without permissions",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
                SideEffect {
                    launcher.launch(
                        arrayOf(
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    )
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val state = viewModel.uiState.collectAsStateWithLifecycle()
                    ForecastScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        uiState = state.value
                    )
                }
            }
        }
    }
}
