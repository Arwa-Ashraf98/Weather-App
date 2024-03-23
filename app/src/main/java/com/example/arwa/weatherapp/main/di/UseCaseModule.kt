package com.example.arwa.weatherapp.main.di

import com.example.arwa.weatherapp.domain.interactors.GetCityDataUseCase
import com.example.arwa.weatherapp.domain.repo.ICityRepo
import com.example.arwa.weatherapp.domain.interactors.GetWeatherDataUseCase
import com.example.arwa.weatherapp.domain.repo.IWeatherRepo
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