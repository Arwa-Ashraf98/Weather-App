package com.example.arwa.weatherapp.search_city.data.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.data.dto.CityItem
import javax.inject.Inject

class CityRemoteDataSource @Inject constructor(
    private val cityServices: CityServices,
) : ICityRemoteDataSource {

    override suspend fun getCityData(cityName: String, limit: Int): ResourceResult<List<CityItem>> {
        val cityDataResponse = cityServices.getCityData(cityName, limit)
        return if (cityDataResponse.isSuccessful) {
            ResourceResult.SUCCESS(cityDataResponse.body() ?: emptyList())
        } else {
            ResourceResult.ERROR(Throwable(cityDataResponse.message()))
        }
    }
}