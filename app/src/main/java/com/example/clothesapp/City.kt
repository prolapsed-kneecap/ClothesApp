package com.example.clothesapp


data class City(
    val coord: Coord?= Coord(0.0, 0.0),
    val country: String? = "",
    val id: Int? = 0,
    val name: String? = "",
    val population: Double? = 0.0,
    val sunrise: Double? = 0.0,
    val sunset: Double? = 0.0,
    val timezone: Double? = 0.0
)