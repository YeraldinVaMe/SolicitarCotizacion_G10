package com.example.solicitarcotizacion.data.repository

import android.util.Log
import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Predio
import com.example.solicitarcotizacion.data.model.PredioItem
import java.lang.Exception

class PredioRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getPredioRepository() : Result<Predio>{
        return try {
            val response = service.listPrediosApiService()
            Result.success(response)
        }catch (e: Exception){
            Log.e("ERROR2", "error terrible", e)
            Result.failure(e)
        }
    }

    suspend fun createPredioRepository(predioItem: PredioItem): Result<Unit> {
        return try {
            val response = service.createPredioApiService(predioItem)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("Error al crear predio"))
            }
        } catch (e: Exception) {
            Log.e("ERROR2", "error terrible", e)
            Result.failure(e)
        }
    }
}
