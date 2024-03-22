package com.example.arwa.weatherapp.data.source.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.models.dto.CityItem
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class RemoteDataSource @Inject constructor(
    private val apiServices: APIServices,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : IRemoteDataSource {

    override suspend fun getCityData(cityName: String, limit: Int): ResourceResult<List<CityItem>> {
        val cityDataResponse = apiServices.getCityData(cityName, limit)
        return withContext(ioDispatcher) {
            try {
                if (cityDataResponse.isSuccessful) {
                    ResourceResult.SUCCESS(cityDataResponse.body() ?: emptyList())
                } else {
                    ResourceResult.ERROR(Throwable(cityDataResponse.errorBody().toString()))
                }
            }catch (e : Exception){
                ResourceResult.ERROR(e)
            }
        }
    }

    override suspend fun getWeatherData(
        lat: Double, lon: Double
    ): ResourceResult<WeatherDto?> {
        return withContext(ioDispatcher) {
            try {
                val response = apiServices.getWeatherData(lat, lon)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    ResourceResult.SUCCESS(responseBody)
                } else {
                    ResourceResult.ERROR(Throwable(response.message()))
                }
            } catch (e: Exception) {
                ResourceResult.ERROR(e)
            }
        }
    }
}