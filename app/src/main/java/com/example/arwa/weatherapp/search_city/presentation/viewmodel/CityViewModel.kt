package com.example.arwa.weatherapp.search_city.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arwa.weatherapp.core.ResourceResult
import com.example.arwa.weatherapp.search_city.domain.interactors.GetCityDataUseCase
import com.example.arwa.weatherapp.search_city.presentation.mapper.toPresentationCityItem
import com.example.arwa.weatherapp.search_city.presentation.state.CitySearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class CityViewModel @Inject constructor(
    private val getCityDataUseCae: GetCityDataUseCase,
    @Named("ioDispatcher") private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _cityState = mutableStateOf(CitySearchState())
    val cityState: State<CitySearchState> = _cityState


    fun getCityDataFromRemote(cityName: String) {
        viewModelScope.launch(ioDispatcher) {
            _cityState.value = CitySearchState(isLoading = true)
            getCityDataUseCae(cityName)
                .collect { res ->
                    when (res) {
                        is ResourceResult.SUCCESS -> {
                            val presentationCityItem =
                                res.data.map { it.toPresentationCityItem() }[0]
                            _cityState.value = CitySearchState(
                                isLoading = false,
                                city = presentationCityItem)
                        }

                        is ResourceResult.ERROR -> {
                            _cityState.value = CitySearchState(
                                isLoading = false,
                                error = res.error?.localizedMessage ?: "An unexpected error occured"
                            )
                        }
                    }
                }
        }
    }
}