package com.example.arwa.weatherapp.search_city.data.dto

data class CityItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)
