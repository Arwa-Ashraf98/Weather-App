package com.example.arwa.weatherapp.weather_data.data.remote

import com.example.arwa.weatherapp.weather_data.domain.models.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object{
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "845b1eb8d9454b1e0a82f08d5e255679"
        private const val EXCLUDE = "minutely"
        private const val relativeLink = "data/2.5/onecall"
    }

    @GET(relativeLink)
    fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = EXCLUDE,
        @Query("appid") apiKey: String = API_KEY,
    ) : Response<WeatherDto>



}