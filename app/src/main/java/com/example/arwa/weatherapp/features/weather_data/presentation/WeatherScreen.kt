package com.example.arwa.weatherapp.features.weather_data.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(error : String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = error ?: "Error Happen" , color = Color.Red)
    }
}

@Composable
fun WeatherDataScreen(lat: String, long: String , ) {


}

@Composable
fun SuccessView(temp : String , description : String , icon : Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Weather Icon - Replace with your actual icon logic
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Weather Condition",
            modifier = Modifier.size(128.dp) // Adjust size as needed
        )

        // Temperature - Assuming 'location' has a temperature property
        Text(
            text = "${temp}°",
            style = MaterialTheme.typography.bodyMedium
        )

        // Description - Assuming 'location' has a description property
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

