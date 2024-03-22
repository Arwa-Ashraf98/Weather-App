package com.example.arwa.weatherapp.weather_data.data.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.weather_data.domain.models.WeatherDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

class WeatherRemoteSource@Inject constructor(
    private val weatherServices: WeatherService,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : IWeatherRemoteSource {

    override fun getWeatherData(
        lat : Double , lon : Double
    ): Flow<ResourceResult<WeatherDto>?> {
        return flow {
            val response = weatherServices.getWeatherData(lat, lon)
            if (response.isSuccessful) {
                val responseBody = response.body()
                ResourceResult.SUCCESS(responseBody)
            } else {
                emit(ResourceResult.ERROR(Throwable(response.message())))
            }
        }.flowOn(ioDispatcher)
    }
}