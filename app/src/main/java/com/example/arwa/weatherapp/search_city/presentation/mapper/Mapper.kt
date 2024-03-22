package com.example.arwa.weatherapp.search_city.presentation.mapper

import com.example.arwa.weatherapp.search_city.domain.model.DomainCityItem
import com.example.arwa.weatherapp.search_city.presentation.model.PresentationCityItem


fun DomainCityItem.toPresentationCityItem(): PresentationCityItem =
    PresentationCityItem(
        lat = this.lat,
        long = this.long,
        name = this.name
    )
