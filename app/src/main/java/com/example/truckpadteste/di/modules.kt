package com.example.truckpadteste.di

import org.koin.core.context.loadKoinModules

val modules = loadKoinModules(
    listOf(
        presentationModule,
        domainModule,
        remoteModule
    )
)
