package com.example.arwa.weatherapp.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.arwa.weatherapp.data.models.entity.CityEntity

@Dao
interface CityDao {

    @Query("SELECT * FROM CITY WHERE name=:cityName")
    suspend fun getCity(cityName: String): CityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(cityEntity: CityEntity)

}