package com.example.arwa.weatherapp.domain.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import com.example.arwa.weatherapp.domain.model.DomainWeather
import kotlinx.coroutines.flow.Flow

interface IWeatherRepo {
    suspend fun getWeatherData(lat : Double , lon : Double) : ResourceResult<DomainWeather>
}