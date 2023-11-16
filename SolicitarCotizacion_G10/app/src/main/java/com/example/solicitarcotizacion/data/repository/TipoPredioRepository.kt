package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.TipoPredio
import java.lang.Exception

class TipoPredioRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getTipoPredioRepository() : Result<TipoPredio>{
        return try {
            val response = service.listTipoPrediosApiService()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
