package com.example.arwa.weatherapp.data.source.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.models.dto.CityItem
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {

    suspend fun getCityData(cityName: String, limit: Int): ResourceResult<List<CityItem>>

    suspend fun getWeatherData(lat: Double, lon: Double): ResourceResult<WeatherDto?>

}