package com.example.solicitarcotizacion.API

import com.example.solicitarcotizacion.Model.G_Persona
import com.example.solicitarcotizacion.Model.G_Ubigeo
import retrofit2.http.GET

interface API_service {
    @GET("/persona")
    suspend fun listPersonaApiService( ):G_Persona

    @GET("/ubigeo")
    suspend fun listUbigeoApiService( ):G_Ubigeo
}