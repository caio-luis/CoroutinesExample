package com.example.truckpadteste.di

import com.example.truckpadteste.domain.RouteAndPriceRepository
import com.example.truckpadteste.remote.GetRouteAndPriceDataImplementation
import org.koin.dsl.module

val remoteModule = module {
    factory<RouteAndPriceRepository> { GetRouteAndPriceDataImplementation() }
}