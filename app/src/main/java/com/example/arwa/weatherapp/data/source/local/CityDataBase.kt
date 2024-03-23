package com.example.arwa.weatherapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.arwa.weatherapp.data.models.entity.CityEntity


@Database(entities = [CityEntity::class] , version = 1 , exportSchema = false)
abstract class CityDataBase : RoomDatabase() {

    abstract fun getCityDao() : CityDao
}