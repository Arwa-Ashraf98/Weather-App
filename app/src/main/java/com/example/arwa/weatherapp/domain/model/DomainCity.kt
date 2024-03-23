package com.example.arwa.weatherapp.domain.model

data class DomainCity(
    val name: String = "",
    val lat: Double = 0.0,
    val long: Double = 0.0,
    val country: String = "",
    val state: String = ""
)
