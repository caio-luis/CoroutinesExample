package com.example.truckpadteste.mapper

import com.example.truckpadteste.json.PriceEnv
import com.example.truckpadteste.json.PriceResponse
import com.example.truckpadteste.json.RouteResponse
import com.example.truckpadteste.model.RouteResult

object RouteResultMapper {

    fun createResultObject(
        routeResponse: RouteResponse,
        priceResponse: PriceResponse
    ): RouteResult {
        return RouteResult(
            distance = routeResponse.distance,
            refrigerated = priceResponse.frigorificada,
            general = priceResponse.geral,
            granel = priceResponse.granel,
            neogranel = priceResponse.neogranel,
            hazardous = priceResponse.perigosa
        )
    }

    fun createPriceEnvObject(distance: Double): PriceEnv {

        return PriceEnv(
            3,
            distance,
            false
        )
    }
}
