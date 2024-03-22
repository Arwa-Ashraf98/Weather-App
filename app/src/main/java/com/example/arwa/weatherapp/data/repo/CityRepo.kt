package com.example.arwa.weatherapp.data.repo

import com.example.arwa.weatherapp.core.ResourceResult
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

    fun getCity(cityName: String, limit: Int): Flow<ResourceResult<List<DomainCity>>> {
        return flow<ResourceResult<List<DomainCity>>> {
            val localData = localDataSource.getCity(cityName)
            if(localData == null) {
                val result  = getCityFromRemote(cityName, limit)

            } else {

            }



        }.catch { e -> ResourceResult.ERROR(e) }
            .flowOn(defaultDispatcher)
    }

    private suspend fun getCityFromRemote(cityName: String, limit: Int) : ResourceResult<List<CityItem>> {
        return when(val result = remoteDataSource.getCityData(cityName, limit)) {
            is ResourceResult.SUCCESS -> {
               ResourceResult.SUCCESS(result.data)
            }

            else -> {
                ResourceResult.ERROR(Throwable("Error Getting City"))
            }
        }

    }


    override suspend fun getCityDataFromRemote(
        cityName: String,
        limit: Int
    ): Flow<ResourceResult<List<DomainCity>>> {
        return flow {
            try {
                when (val cityResult = remoteDataSource.getCityData(cityName, limit)) {
                    is ResourceResult.SUCCESS -> {
                        val domainCityData = cityResult.data.map {
                            it.toDomainCityItem()
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
        }.catch { e -> emit(ResourceResult.ERROR(e)) }
            .flowOn(defaultDispatcher)
    }

    override suspend fun getCityFromLocal(cityName: String): ResourceResult<CityEntity> {
        val cityEntity = localDataSource.getCity(cityName)
        return if (cityEntity != null) {
            ResourceResult.SUCCESS(cityEntity)
        } else {
            ResourceResult.ERROR(Throwable("There is no Such City"))
        }
    }

    override suspend fun saveCity(cityEntity: CityEntity) {
        return localDataSource.saveCity(cityEntity)
    }

}