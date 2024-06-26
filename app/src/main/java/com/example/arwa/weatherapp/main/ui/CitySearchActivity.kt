package com.example.arwa.weatherapp.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.arwa.weatherapp.features.search_city.presentation.ui.SearchCityScreen
import com.example.arwa.weatherapp.features.search_city.presentation.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CitySearchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
    }

    private fun initUi() {
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
//                    SearchCityScreen(navController = rememberNavController())
                }
            }
        }
    }

}


