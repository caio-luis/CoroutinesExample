package com.example.truckpadteste.di

import com.example.truckpadteste.domain.interactor.GetRouteAndPriceDataUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetRouteAndPriceDataUseCase(get()) }
}