package com.example.arwa.weatherapp.search_city.presentation.state

import com.example.arwa.weatherapp.search_city.presentation.model.PresentationCityItem


data class CitySearchState(
    val isLoading: Boolean = false,
    val city: PresentationCityItem?= null,
    val error: String = ""
)