package com.example.arwa.weatherapp.search_city.domain.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.domain.model.DomainCityItem
import kotlinx.coroutines.flow.Flow


interface ICityRepo {

    suspend fun getCityData(cityName : String , limit : Int = 1) : Flow<ResourceResult<List<DomainCityItem>>>
}