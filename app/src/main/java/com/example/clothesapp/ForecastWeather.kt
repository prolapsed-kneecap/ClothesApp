package com.example.clothesapp

data class ForecastWeather(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<WeatherInfo> = listOf(),
    val message: Int = 0
)