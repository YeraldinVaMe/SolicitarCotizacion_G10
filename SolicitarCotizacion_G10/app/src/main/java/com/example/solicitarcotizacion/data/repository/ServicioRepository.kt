package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Servicio
import java.lang.Exception

class ServicioRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getServicioRepository() : Result<Servicio>{
        return try {
            val response = service.listServiciosApiService()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
