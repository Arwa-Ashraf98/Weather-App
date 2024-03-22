package com.example.arwa.weatherapp.data.repo

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.data.mapper.toCityEntity
import com.example.arwa.weatherapp.data.mapper.toDomainCity
import com.example.arwa.weatherapp.data.mapper.toDomainCityItem
import com.example.arwa.weatherapp.data.models.dto.CityItem
import com.example.arwa.weatherapp.data.models.entity.CityEntity
import com.example.arwa.weatherapp.data.source.local.ILocalDataSource
import com.example.arwa.weatherapp.data.source.remote.IRemoteDataSource
import com.example.arwa.weatherapp.domain.model.DomainCity
import com.example.arwa.weatherapp.domain.repo.ICityRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

class CityRepo @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
    @Named("defaultDispatcher") private val defaultDispatcher: CoroutineDispatcher
) : ICityRepo {

    override suspend fun getCity(cityName: String, limit: Int): Flow<ResourceResult<List<DomainCity>>> {
        return flow {
            val localData = getCityFromLocal(cityName)
            if (localData == null) {
                when (val result = getCityFromRemote(cityName, limit)) {
                    is ResourceResult.SUCCESS -> {
                        val domainCity = result.data.map { it.toDomainCityItem() }
                        saveCity(result.data[0].toCityEntity())
                        emit(ResourceResult.SUCCESS(domainCity))
                    }

                    else -> {
                        emit(ResourceResult.ERROR(Throwable("Error Getting City")))
                    }
                }
            } else {
                val domainCity = listOf(localData.toDomainCity())
                emit(ResourceResult.SUCCESS(domainCity))
            }


        }.catch { e -> ResourceResult.ERROR(e) }
            .flowOn(defaultDispatcher)
    }

    private suspend fun getCityFromRemote(
        cityName: String,
        limit: Int
    ): ResourceResult<List<CityItem>> {
        return when (val result = remoteDataSource.getCityData(cityName, limit)) {
            is ResourceResult.SUCCESS -> {
                ResourceResult.SUCCESS(result.data)
            }

            else -> {
                ResourceResult.ERROR(Throwable("Error Getting City"))
            }
        }

    }

    private suspend fun getCityFromLocal(cityName: String): CityEntity? {
        return localDataSource.getCity(cityName)
    }

    private suspend fun saveCity(cityEntity: CityEntity) {
        return localDataSource.saveCity(cityEntity)
    }

}