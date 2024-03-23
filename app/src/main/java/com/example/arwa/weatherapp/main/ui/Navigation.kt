package com.example.arwa.weatherapp.main.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arwa.weatherapp.features.search_city.presentation.ui.SearchCityScreen
import com.example.arwa.weatherapp.features.weather_data.presentation.WeatherDataScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CitySearchScreen.route) {
        composable(route = Screen.CitySearchScreen.route) {
            SearchCityScreen(navController = navController)
        }

        composable(route = Screen.WeatherScreen.route + "/{lat}/{long}", arguments = listOf(
            navArgument("lat") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("long") {
                type = NavType.StringType
                defaultValue = ""
            }
        )) { entry ->
            WeatherDataScreen(
                lat = entry.arguments?.getString("lat") ?: "",
                long = entry.arguments?.getString("long") ?: ""
            )

        }
    }
}