package com.example.truckpadteste.domain

import com.example.truckpadteste.json.PriceEnv
import com.example.truckpadteste.json.PriceResponse
import com.example.truckpadteste.json.RouteEnv
import com.example.truckpadteste.json.RouteResponse
import com.example.truckpadteste.remote.ApiService

interface RouteAndPriceRepository {
    suspend fun getRouteDataInfo(routeEnv: RouteEnv): RouteResponse
    suspend fun getPriceDataInfo(priceEnv: PriceEnv): PriceResponse
}