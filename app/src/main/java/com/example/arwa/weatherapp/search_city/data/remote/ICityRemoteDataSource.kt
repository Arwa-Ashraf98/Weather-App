package com.example.arwa.weatherapp.search_city.data.remote

import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.data.dto.CityItem

interface ICityRemoteDataSource {

    suspend fun getCityData(cityName : String , limit : Int) : ResourceResult<List<CityItem>>

}