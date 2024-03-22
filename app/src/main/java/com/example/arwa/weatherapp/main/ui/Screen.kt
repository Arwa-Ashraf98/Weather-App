package com.example.arwa.weatherapp.main.ui

sealed class Screen(val route : String){
    object CitySearchScreen : Screen("city_search_screen")
    object WeatherScreen : Screen("weather_screen")

    fun withArgs(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
