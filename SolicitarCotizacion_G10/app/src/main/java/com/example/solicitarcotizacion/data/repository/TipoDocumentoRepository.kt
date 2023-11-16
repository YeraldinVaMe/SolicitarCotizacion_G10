package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.TipoDocumento
import java.lang.Exception

class TipoDocumentoRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getTipoDocumentoRepository() : Result<TipoDocumento>{
        return try {
            val response = service.listTipoDocumentosApiService()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
