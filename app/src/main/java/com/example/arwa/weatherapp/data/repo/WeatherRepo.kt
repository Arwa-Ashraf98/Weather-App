package com.example.arwa.weatherapp.data.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.mapper.toDomainWeather
import com.example.arwa.weatherapp.data.source.remote.IRemoteDataSource
import com.example.arwa.weatherapp.domain.model.DomainWeather
import com.example.arwa.weatherapp.domain.repo.IWeatherRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class WeatherRepo @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    @Named("defaultDispatcher") private val defaultDispatcher: CoroutineDispatcher
) : IWeatherRepo {
    override suspend fun getWeatherData(lat: Double, lon: Double): ResourceResult<DomainWeather> {
        return withContext(defaultDispatcher) {
            try {
                when (val weatherResult = remoteDataSource.getWeatherData(lat = lat, lon = lon)) {
                    is ResourceResult.SUCCESS -> {
                        val domainWeather = weatherResult.data?.toDomainWeather()
                        ResourceResult.SUCCESS(domainWeather ?: DomainWeather())
                    }

                    else -> {
                        ResourceResult.ERROR(Throwable("Failed to fetch City Data"))
                    }
                }
            } catch (e: Exception) {
                ResourceResult.ERROR(e)
            }
        }

    }

}