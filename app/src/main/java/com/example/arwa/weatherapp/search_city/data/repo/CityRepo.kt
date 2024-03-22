package com.example.arwa.weatherapp.search_city.data.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.data.mapper.toCityItemToDomainCityItem
import com.example.arwa.weatherapp.search_city.data.remote.ICityRemoteDataSource
import com.example.arwa.weatherapp.search_city.domain.model.DomainCityItem
import com.example.arwa.weatherapp.search_city.domain.repo.ICityRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

class CityRepo @Inject constructor(
    private val remoteDataSource: ICityRemoteDataSource,
    @Named("defaultDispatcher") private val defaultDispatcher: CoroutineDispatcher
) :
    ICityRepo {

    override suspend fun getCityData(
        cityName: String,
        limit: Int
    ): Flow<ResourceResult<List<DomainCityItem>>> {
        return flow {
            try {
                when (val cityResult = remoteDataSource.getCityData(cityName, limit)) {
                    is ResourceResult.SUCCESS -> {
                        val domainCityData = cityResult.data.map {
                            it.toCityItemToDomainCityItem()
                        }
                        emit(ResourceResult.SUCCESS(domainCityData))
                    }

                    else -> {
                        emit(ResourceResult.ERROR(Throwable("Failed to fetch City Data")))
                    }
                }
            } catch (e: Exception) {
                emit(ResourceResult.ERROR(e))
            }
        }.catch { e -> emit(ResourceResult.ERROR(e))}
            .flowOn(defaultDispatcher)
    }
}