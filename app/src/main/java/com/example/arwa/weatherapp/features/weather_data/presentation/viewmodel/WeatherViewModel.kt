package com.example.arwa.weatherapp.features.weather_data.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.domain.interactors.GetWeatherDataUseCase
import com.example.arwa.weatherapp.domain.model.DomainWeather
import com.example.arwa.weatherapp.main.state.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _weatherState = mutableStateOf(ScreenState<DomainWeather>())
    val weatherState: State<ScreenState<DomainWeather>> = _weatherState

    suspend fun getWeatherData(lat: Double, long: Double) {
        _weatherState.value = ScreenState(isLoading = true)
        viewModelScope.launch(ioDispatcher) {
            when (val res = getWeatherDataUseCase(lat, long)) {
                is ResourceResult.SUCCESS -> {
                    val weatherData = res.data
                    _weatherState.value = ScreenState(isLoading = false, data = weatherData)
                }

                else -> {
                    _weatherState.value = ScreenState(isLoading = false, error = "Error")
                }
            }
        }
    }

}