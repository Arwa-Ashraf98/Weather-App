package com.example.arwa.weatherapp.features.weather_data.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.main.state.ScreenState
import com.example.arwa.weatherapp.domain.interactors.GetWeatherDataUseCase
import com.example.arwa.weatherapp.data.models.dto.WeatherDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _weatherState = mutableStateOf(ScreenState<WeatherDto>())
    val weatherState: State<ScreenState<WeatherDto>> = _weatherState

    fun getWeatherData(lat: Double, long: Double) {
        _weatherState.value = ScreenState(isLoading = true)
        getWeatherDataUseCase(lat, long).onEach { res ->
            when(res) {
                is ResourceResult.SUCCESS -> {
                    val weatherData = res.data
                    _weatherState.value = ScreenState(isLoading = false , data = weatherData)
                }

                else -> {
                    _weatherState.value = ScreenState(isLoading = false , error = "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

}