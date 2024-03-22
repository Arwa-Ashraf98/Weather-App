package com.example.arwa.weatherapp.weather_data.data.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.weather_data.domain.models.WeatherDto
import kotlinx.coroutines.flow.Flow

interface IWeatherRemoteSource {
    fun getWeatherData(lat : Double , lon : Double ) : Flow<ResourceResult<WeatherDto>?>

}