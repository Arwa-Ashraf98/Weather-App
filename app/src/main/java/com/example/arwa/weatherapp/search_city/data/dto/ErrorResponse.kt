package com.example.arwa.weatherapp.search_city.data.dto

data class ErrorResponse(
    val cod: Int,
    override val message: String,
    val parameters: List<String>
) : Throwable()