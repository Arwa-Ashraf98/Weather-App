package com.example.arwa.weatherapp.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.arwa.weatherapp.core.Constants


@Entity(tableName =  Constants.CITY_TABLE_NAME)
data class CityEntity(
    val name : String ,
    val latitude : Double ,
    val longitude : Double ,
    @PrimaryKey(autoGenerate = true)
    val id : Int ?= 0
)
