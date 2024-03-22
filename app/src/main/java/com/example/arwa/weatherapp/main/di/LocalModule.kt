package com.example.arwa.weatherapp.main.di

import android.content.Context
import androidx.room.Room
import com.example.arwa.weatherapp.core.Constants
import com.example.arwa.weatherapp.data.source.local.CityDao
import com.example.arwa.weatherapp.data.source.local.CityDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideCityDatabase(@ApplicationContext appContext: Context): CityDataBase {
        return Room.databaseBuilder(
            appContext,
            CityDataBase::class.java,
            Constants.DATA_BASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCityDao(cityDataBase: CityDataBase) : CityDao{
        return cityDataBase.getCityDao()
    }
}