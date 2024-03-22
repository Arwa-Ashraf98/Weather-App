package com.example.arwa.weatherapp.main.di

import com.example.arwa.weatherapp.search_city.data.remote.CityRemoteDataSource
import com.example.arwa.weatherapp.search_city.data.remote.ICityRemoteDataSource
import com.example.arwa.weatherapp.weather_data.data.remote.IWeatherRemoteSource
import com.example.arwa.weatherapp.weather_data.data.remote.WeatherRemoteSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindWeatherRemoteDataSource(weatherRemoteSource: WeatherRemoteSource): IWeatherRemoteSource

    @Binds
    abstract fun bindCityRemoteDataSource(cityRemoteDataSource: CityRemoteDataSource): ICityRemoteDataSource

}