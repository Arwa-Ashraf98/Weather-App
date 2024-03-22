package com.example.arwa.weatherapp.data.source.local

import com.example.arwa.weatherapp.data.models.entity.CityEntity

interface ILocalDataSource {

    suspend fun getCity(cityName : String) : CityEntity?

    suspend fun saveCity(cityEntity: CityEntity)
}