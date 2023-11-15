package com.example.solicitarcotizacion.data.repository

import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Personal
import java.lang.Exception

class PersonalRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getPersonalRepository() : Result<Personal>{
        return try {
            val response = service.listPersonalApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}
