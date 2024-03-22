package com.example.arwa.weatherapp.core

sealed interface ResourceResult<out T> {
    data class SUCCESS<T>(val data: T) : ResourceResult<T>
    data class ERROR(val error: Throwable?) : ResourceResult<Nothing>
}