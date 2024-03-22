package com.example.arwa.weatherapp.weather_data.data.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.weather_data.data.remote.IWeatherRemoteSource
import com.example.arwa.weatherapp.weather_data.domain.models.WeatherDto
import com.example.arwa.weatherapp.weather_data.domain.repo.IWeatherRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepo @Inject constructor(
    private val weatherRemoteDataSource: IWeatherRemoteSource) : IWeatherRepo {
    override fun getWeatherData(lat: Double, lon: Double): Flow<ResourceResult<WeatherDto>?> {
        return weatherRemoteDataSource.getWeatherData(lat, lon)
    }
}