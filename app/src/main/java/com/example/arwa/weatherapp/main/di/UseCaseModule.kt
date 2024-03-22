package com.example.arwa.weatherapp.main.di

import com.example.arwa.weatherapp.search_city.domain.interactors.GetCityDataUseCase
import com.example.arwa.weatherapp.search_city.domain.repo.ICityRepo
import com.example.arwa.weatherapp.weather_data.domain.interactors.GetWeatherDataUseCase
import com.example.arwa.weatherapp.weather_data.domain.repo.IWeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetWeatherDataUseCase(
        weatherRepo : IWeatherRepo
    ): GetWeatherDataUseCase = GetWeatherDataUseCase(weatherRepo)

    @Provides
    fun provideGetCityDataUseCase(cityRepo: ICityRepo) : GetCityDataUseCase = GetCityDataUseCase(cityRepo)
}