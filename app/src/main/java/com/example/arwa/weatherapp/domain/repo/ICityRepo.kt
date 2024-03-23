package com.example.arwa.weatherapp.domain.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.models.entity.CityEntity
import com.example.arwa.weatherapp.domain.model.DomainCity
import kotlinx.coroutines.flow.Flow


interface ICityRepo {

    suspend fun getCity(cityName: String, limit: Int = 1): Flow<ResourceResult<List<DomainCity>>>

}