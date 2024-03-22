package com.example.arwa.weatherapp.weather_data.domain.models

data class WeatherDto(
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)