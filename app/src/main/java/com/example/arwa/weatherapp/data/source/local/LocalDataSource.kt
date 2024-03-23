package com.example.arwa.weatherapp.data.source.local

import com.example.arwa.weatherapp.data.models.entity.CityEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class LocalDataSource @Inject constructor(
    private val cityDao: CityDao,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : ILocalDataSource {


    override suspend fun getCity(cityName : String): CityEntity? {
        return withContext(ioDispatcher){
            cityDao.getCity(cityName)
        }
    }

    override suspend fun saveCity(cityEntity: CityEntity) {
        return withContext(ioDispatcher){
            cityDao.saveCity(cityEntity)
        }
    }
}