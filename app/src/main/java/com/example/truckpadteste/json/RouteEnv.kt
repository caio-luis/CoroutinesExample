package com.example.truckpadteste.json

data class RouteEnv(
    var places: List<Place>,
    val fuel_consumption: Int,
    val fuel_price: Double
)

data class Place(
    val point: List<Double>
)