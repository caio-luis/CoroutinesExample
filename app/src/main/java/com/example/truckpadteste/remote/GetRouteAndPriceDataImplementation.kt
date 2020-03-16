package com.example.truckpadteste.remote

import com.example.truckpadteste.domain.RouteAndPriceRepository
import com.example.truckpadteste.json.PriceEnv
import com.example.truckpadteste.json.PriceResponse
import com.example.truckpadteste.json.RouteEnv
import com.example.truckpadteste.json.RouteResponse
import java.lang.Exception

class GetRouteAndPriceDataImplementation(
): RouteAndPriceRepository {

    override suspend fun getRouteDataInfo(routeEnv: RouteEnv): RouteResponse {
        return try {
             ApiService.routeService.createRoutePost(routeEnv)
        }catch (ex: Exception){
            throw ex
        }
    }

    override suspend fun getPriceDataInfo(priceEnv: PriceEnv): PriceResponse {

        return try {
            ApiService.priceService.createPricePost(priceEnv)
        }catch (ex: Exception){
            throw ex
        }
    }
}