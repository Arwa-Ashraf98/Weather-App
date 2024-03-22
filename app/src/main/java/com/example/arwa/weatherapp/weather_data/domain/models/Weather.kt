package com.example.arwa.weatherapp.weather_data.domain.models

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)