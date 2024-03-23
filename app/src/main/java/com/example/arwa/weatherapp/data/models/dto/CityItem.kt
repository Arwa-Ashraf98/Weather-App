package com.example.arwa.weatherapp.data.models.dto

data class CityItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)
