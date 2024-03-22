package com.example.arwa.weatherapp.domain.model

data class DomainWeather(
    val temperature : Double ?= 0.0,
    val description : String ?= "",
    val iconUrl : String  ?= "",
    val lat : Double ?= 0.0,
    val long : Double ?= 0.0
)
