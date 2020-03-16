package com.example.truckpadteste.domain.interactor

import com.example.truckpadteste.domain.RouteAndPriceRepository
import com.example.truckpadteste.json.RouteEnv
import com.example.truckpadteste.mapper.RouteResultMapper.createPriceEnvObject
import com.example.truckpadteste.mapper.RouteResultMapper.createResultObject
import com.example.truckpadteste.model.RouteResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.lang.Exception

class GetRouteAndPriceDataUseCase(private val repository: RouteAndPriceRepository) {

    suspend fun getRouteResultData(routeEnv: RouteEnv): RouteResult {

        val routeResult = CoroutineScope(IO).async {

            val routeResponse =
                withContext(IO) {
                    try {
                        repository.getRouteDataInfo(routeEnv)
                    }catch (ex: Exception){
                        throw ex
                    }
                }

            val priceResponse =
                withContext(IO) {

                    try {
                        repository.getPriceDataInfo(
                            createPriceEnvObject(routeResponse.distance.toDouble())
                        )
                    }catch (ex: Exception){
                        throw ex
                    }
                }

            createResultObject(routeResponse, priceResponse)
        }

        return routeResult.await()
    }
}