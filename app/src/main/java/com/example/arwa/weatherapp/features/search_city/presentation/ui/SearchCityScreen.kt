package com.example.arwa.weatherapp.features.search_city.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.arwa.weatherapp.main.ui.Screen
import com.example.arwa.weatherapp.features.search_city.presentation.viewmodel.CityViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCityScreen(cityViewModel: CityViewModel = hiltViewModel(), navController: NavController) {
    var cityNameInput by rememberSaveable { mutableStateOf("") }
    val cityState = cityViewModel.cityState.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = cityNameInput,
            onValueChange = { cityNameInput = it },
            label = { Text("Enter City Name") },
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                if (cityNameInput.isNotBlank()) {
                    cityViewModel.getCityDataFromRemote(cityNameInput)
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Save")
        }
    }

    if (cityState.isLoading) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (cityState.error.isNotBlank()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = cityState.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
    } else if (cityState.data != null) {
        navController.navigate(
            Screen.WeatherScreen.withArgs(
                cityState.data.lat.toString(),
                cityState.data.long.toString()
            )
        )
    }
}
