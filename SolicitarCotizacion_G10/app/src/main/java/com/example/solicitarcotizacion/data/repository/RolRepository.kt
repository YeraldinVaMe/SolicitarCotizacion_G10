package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Rol
import java.lang.Exception

class RolRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getRolRepository() : Result<Rol>{
        return try {
            val response = service.listRolesApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}
