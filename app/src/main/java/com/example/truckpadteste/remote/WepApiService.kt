package com.example.truckpadteste.remote

import com.example.truckpadteste.json.PriceEnv
import com.example.truckpadteste.json.PriceResponse
import com.example.truckpadteste.json.RouteEnv
import com.example.truckpadteste.json.RouteResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface WepApiService {

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("v1/route")
    suspend fun createRoutePost(@Body model: RouteEnv): RouteResponse

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("v1/antt_price/all")
    suspend fun createPricePost(@Body model: PriceEnv): PriceResponse
}