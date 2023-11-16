package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.AreaComun
import java.lang.Exception


class AreaComunRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getAreaComunRepository() : Result<AreaComun>{
        return try {
            val response = service.listAreasComunesApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}