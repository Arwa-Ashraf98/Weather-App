package com.example.arwa.weatherapp.weather_data.domain.interactors

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.weather_data.domain.models.WeatherDto
import com.example.arwa.weatherapp.weather_data.domain.repo.IWeatherRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepo : IWeatherRepo
) {

    operator fun invoke(lat : Double , lon : Double): Flow<ResourceResult<WeatherDto>?> {
        return weatherRepo.getWeatherData(lat, lon)
    }
}