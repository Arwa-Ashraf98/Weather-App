package com.example.arwa.weatherapp.data.models.dto

data class ErrorResponse(
    val cod: Int,
    override val message: String,
    val parameters: List<String>
) : Throwable()