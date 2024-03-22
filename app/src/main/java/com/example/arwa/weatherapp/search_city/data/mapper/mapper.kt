package com.example.arwa.weatherapp.search_city.data.mapper

import com.example.arwa.weatherapp.search_city.data.dto.CityItem
import com.example.arwa.weatherapp.search_city.domain.model.DomainCityItem


fun CityItem.toCityItemToDomainCityItem(): DomainCityItem {
    return DomainCityItem(
        name = this.name,
        country = this.country,
        lat = this.lat,
        long = this.lon,
        state = this.state
    )
}