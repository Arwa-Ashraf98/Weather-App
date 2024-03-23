package com.example.arwa.weatherapp.features.search_city.presentation.mapper

import com.example.arwa.weatherapp.domain.model.DomainCity
import com.example.arwa.weatherapp.features.search_city.presentation.model.PresentationCityItem


fun DomainCity.toPresentationCityItem(): PresentationCityItem =
    PresentationCityItem(
        lat = this.lat,
        long = this.long,
        name = this.name
    )
