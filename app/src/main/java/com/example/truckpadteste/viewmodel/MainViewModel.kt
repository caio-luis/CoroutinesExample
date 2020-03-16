package com.example.truckpadteste.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.truckpadteste.domain.interactor.GetRouteAndPriceDataUseCase
import com.example.truckpadteste.json.RouteEnv
import com.example.truckpadteste.model.RouteResult
import com.example.truckpadteste.model.fakeRouteJson
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(
    private val routeAndPriceUseCase: GetRouteAndPriceDataUseCase
) : ViewModel() {

    private val routeResultLiveData: MutableLiveData<RouteResult> = MutableLiveData()
    val observableRouteResultLiveData: LiveData<RouteResult> = routeResultLiveData

    private val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val observableErrorLiveData: LiveData<String> = errorLiveData

    fun startApiCall() {

        CoroutineScope(IO).launch {

            try {
                routeAndPriceUseCase.getRouteResultData(
                    fakeRouteEnvObject()
                ).also { result ->
                    updateRouteResultLiveData(result)
                }
            } catch (ex: Exception) {
                errorLiveData.postValue(ex.message)
            }
        }
    }

    private fun fakeRouteEnvObject(): RouteEnv {
        return Gson().fromJson(fakeRouteJson, RouteEnv::class.java)
    }

    private fun updateRouteResultLiveData(result: RouteResult) {
        routeResultLiveData.postValue(result)
    }
}