package com.example.arwa.weatherapp.domain.interactors

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.domain.model.DomainCity
import com.example.arwa.weatherapp.domain.repo.ICityRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityDataUseCase @Inject constructor(private val cityRepo: ICityRepo) {

    suspend operator fun invoke(cityName: String): Flow<ResourceResult<List<DomainCity>>> {
        return cityRepo.getCity(cityName)
    }
}