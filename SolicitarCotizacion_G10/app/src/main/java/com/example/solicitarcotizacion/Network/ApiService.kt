package com.example.solicitarcotizacion.Network

import com.example.solicitarcotizacion.data.model.AreaComun
import com.example.solicitarcotizacion.data.model.Persona
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.Personal
import com.example.solicitarcotizacion.data.model.Predio
import com.example.solicitarcotizacion.data.model.PredioAreaComun
import com.example.solicitarcotizacion.data.model.PredioItem
import com.example.solicitarcotizacion.data.model.Rol
import com.example.solicitarcotizacion.data.model.Servicio
import com.example.solicitarcotizacion.data.model.Solicitante
import com.example.solicitarcotizacion.data.model.SolicitanteItem
import com.example.solicitarcotizacion.data.model.Solicitud
import com.example.solicitarcotizacion.data.model.TipoDocumento
import com.example.solicitarcotizacion.data.model.TipoPredio
import com.example.solicitarcotizacion.data.model.Ubigeo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/predio")
    suspend fun listPrediosApiService(): Predio

    @POST("/predio")
    suspend fun createPredioApiService(@Body predioItem: PredioItem): Response<Unit>

    @GET("/areacomun")
    suspend fun listAreasComunesApiService(): AreaComun

    @GET("/persona")
    suspend fun listPersonasApiService(): Persona

    @POST("/persona")
    suspend fun createPersonaApiService(@Body personaItem: PersonaItem): Response<Unit>

    @GET("/personal")
    suspend fun listPersonalApiService(): Personal

    @GET("/predio_area_comun")
    suspend fun listPredioAreaComunApiService(): PredioAreaComun

    @GET("/rol")
    suspend fun listRolesApiService(): Rol

    @GET("/servicio")
    suspend fun listServiciosApiService(): Servicio

    @GET("/solicitante")
    suspend fun listSolicitantesApiService(): Solicitante

    @POST("/solicitante")
    suspend fun createSolicitanteApiService(@Body solicitanteItem: SolicitanteItem): Response<Unit>

    @GET("/solicitud")
    suspend fun listSolicitudesApiService(): Solicitud

    @GET("/tipo_documento")
    suspend fun listTipoDocumentosApiService(): TipoDocumento

    @GET("/tipo_predio")
    suspend fun listTipoPrediosApiService(): TipoPredio

    @GET("/ubigeo")
    suspend fun listUbigeosApiService(): Ubigeo

}