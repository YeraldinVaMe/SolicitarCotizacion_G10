package com.example.solicitarcotizacion.data.repository

import android.util.Log
import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.Solicitante
import com.example.solicitarcotizacion.data.model.SolicitanteItem
import java.lang.Exception

class SolicitanteRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getSolicitanteRepository() : Result<Solicitante>{
        return try {
            val response = service.listSolicitantesApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun createSolicitanteRepository(solicitanteItem: SolicitanteItem): Result<Unit> {
        return try {
            val response = service.createSolicitanteApiService(solicitanteItem)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("Error al crear solicitud"))
            }
        } catch (e: Exception) {
            Log.e("ERROR2", "error terrible", e)
            Result.failure(e)
        }
    }
}
