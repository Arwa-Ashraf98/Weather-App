package com.example.arwa.weatherapp.search_city.domain.interactors

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.domain.model.DomainCityItem
import com.example.arwa.weatherapp.search_city.domain.repo.ICityRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityDataUseCase @Inject constructor(private val cityRepo: ICityRepo) {

    suspend operator fun invoke(cityName: String): Flow<ResourceResult<List<DomainCityItem>>> {
        return cityRepo.getCityData(cityName)
    }
}