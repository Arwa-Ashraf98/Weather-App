package com.example.arwa.weatherapp.main.state


data class ScreenState <out T> (
    val isLoading: Boolean = false,
    val data: T?= null,
    val error: String = ""
)