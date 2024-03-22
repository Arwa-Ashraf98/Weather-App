package com.example.arwa.weatherapp.data.source.remote

import com.example.arwa.weatherapp.data.models.dto.CityItem
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {

    companion object {
        const val BASE_URL = "http://api.openweathermap.org/"
        private const val cityRelativeLink = "geo/1.0/direct"
        private const val API_KEY = "845b1eb8d9454b1e0a82f08d5e255679"
        private const val weatherRelativeLink = "data/2.5/onecall"
        private const val EXCLUDE = "minutely,hourly,alerts"
    }


    @GET(cityRelativeLink)
    suspend fun getCityData(
        @Query("q") cityName: String,
        @Query("limit") limit: Int,
        @Query("appid") appId: String = API_KEY
    ): Response<List<CityItem>>

    @GET(weatherRelativeLink)
    fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = EXCLUDE,
        @Query("appid") apiKey: String = API_KEY,
    ): Response<WeatherDto>


}