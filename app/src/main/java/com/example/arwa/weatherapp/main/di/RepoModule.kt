package com.example.arwa.weatherapp.main.di

import com.example.arwa.weatherapp.search_city.data.repo.CityRepo
import com.example.arwa.weatherapp.search_city.domain.repo.ICityRepo
import com.example.arwa.weatherapp.weather_data.data.repo.WeatherRepo
import com.example.arwa.weatherapp.weather_data.domain.repo.IWeatherRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun bindWeatherRepo(weatherRepo: WeatherRepo) : IWeatherRepo

    @Binds
    abstract fun bindCityRepo(cityRepo: CityRepo) : ICityRepo
}

