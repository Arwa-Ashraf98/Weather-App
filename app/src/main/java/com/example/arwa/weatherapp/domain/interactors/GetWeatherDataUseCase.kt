package com.example.arwa.weatherapp.domain.interactors

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.domain.model.DomainWeather
import com.example.arwa.weatherapp.domain.repo.IWeatherRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepo : IWeatherRepo
) {
    suspend operator fun invoke(lat : Double, lon : Double): ResourceResult<DomainWeather?>{
        return weatherRepo.getWeatherData(lat, lon)
    }
}