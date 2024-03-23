package com.example.arwa.weatherapp.features.search_city.presentation.model

import java.io.Serializable

data class PresentationCityItem(
    val lat : Double ,
    val long : Double ,
    val name : String
) : Serializable
