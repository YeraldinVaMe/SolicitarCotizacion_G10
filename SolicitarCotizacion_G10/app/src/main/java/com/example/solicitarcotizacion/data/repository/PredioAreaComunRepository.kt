package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.PredioAreaComun
import java.lang.Exception

class PredioAreaComunRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getPredioAreaComunRepository() : Result<PredioAreaComun>{
        return try {
            val response = service.listPredioAreaComunApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}
