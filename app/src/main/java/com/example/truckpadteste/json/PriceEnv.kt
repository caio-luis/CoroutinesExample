package com.example.truckpadteste.json

data class PriceEnv(
    var axis: Int,
    var distance: Double,
    val has_return_shipment: Boolean
)