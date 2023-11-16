package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Solicitud
import java.lang.Exception

class SolicitudRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getSolicitudRepository() : Result<Solicitud>{
        return try {
            val response = service.listSolicitudesApiService()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
