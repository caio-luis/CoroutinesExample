package com.example.truckpadteste.activity

import android.app.Application
import com.example.truckpadteste.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules
        }
    }
}