package com.example.arwa.weatherapp.data.models.dto

import com.example.arwa.weatherapp.data.models.dto.Current
import com.example.arwa.weatherapp.data.models.dto.Daily

data class WeatherDto(
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)