package com.example.arwa.weatherapp.data.mapper

import com.example.arwa.weatherapp.data.models.dto.CityItem
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import com.example.arwa.weatherapp.data.models.entity.CityEntity
import com.example.arwa.weatherapp.domain.model.DomainCity
import com.example.arwa.weatherapp.domain.model.DomainWeather


fun CityItem.toDomainCityItem(): DomainCity {
    return DomainCity(
        name = this.name,
        country = this.country,
        lat = this.lat,
        long = this.lon,
        state = this.state
    )
}

fun WeatherDto.toDomainWeather(): DomainWeather {
    return DomainWeather(
        temperature = this.current.temp,
        lat = this.lat,
        long = this.lon,
        description = this.current.weather[0].description,
        iconUrl = this.current.weather[0].icon

    )
}

fun CityItem.toCityEntity(): CityEntity {
    return CityEntity(
        name = this.name,
        latitude = this.lat,
        longitude = this.lon
    )
}

fun CityEntity.toDomainCity(): DomainCity {
    return DomainCity(
        lat = this.latitude, long = this.longitude, name = this.name
    )
}
