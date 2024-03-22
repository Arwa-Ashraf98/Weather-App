package com.example.arwa.weatherapp.search_city.data.remote

import com.example.arwa.weatherapp.search_city.data.dto.CityItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CityServices {

    companion object {
        private const val relativeLink = "geo/1.0/direct"
        private const val API_KEY = "845b1eb8d9454b1e0a82f08d5e255679"
    }


    @GET(relativeLink)
    suspend fun getCityData(
        @Query("q") cityName : String ,
        @Query("limit") limit : Int ,
        @Query("appid") appId : String =  API_KEY
    ) : Response<List<CityItem>>

}