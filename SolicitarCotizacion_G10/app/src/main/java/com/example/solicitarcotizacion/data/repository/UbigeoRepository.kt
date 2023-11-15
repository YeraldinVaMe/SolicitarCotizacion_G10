package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Ubigeo
import java.lang.Exception

class UbigeoRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getUbigeoRepository() : Result<Ubigeo>{
        return try {
            val response = service.listUbigeosApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}
