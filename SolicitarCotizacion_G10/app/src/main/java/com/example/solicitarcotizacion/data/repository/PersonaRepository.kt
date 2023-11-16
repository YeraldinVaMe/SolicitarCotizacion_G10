package com.example.solicitarcotizacion.data.repository

import android.util.Log
import com.example.solicitarcotizacion.Network.ApiInstance
import com.example.solicitarcotizacion.data.model.Persona
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.PredioItem
import java.lang.Exception

class PersonaRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getPersonasRepository() : Result<Persona>{
        return try {
            val response = service.listPersonasApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun createPersonaRepository(personaItem: PersonaItem): Result<Unit> {
        return try {
            val response = service.createPersonaApiService(personaItem)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("Error al crear persona"))
            }
        } catch (e: Exception) {
            Log.e("ERROR2", "error terrible", e)
            Result.failure(e)
        }
    }

    suspend fun obtenerId():Int?{
        val response = service.listPersonasApiService()
        if (response.isNotEmpty()){
            return response[0].id_persona
        } else {
            return null
        }
    }
}
