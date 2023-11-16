package com.example.solicitarcotizacion.data.model

data class SolicitudItem(
    val area_acomunes: Double,
    val area_predio: String,
    val cant_acomunes: Int,
    val cant_administracion: Int,
    val cant_jardineria: Int,
    val cant_plimpieza: Int,
    val cant_vigilantes: Int,
    val fecha_solicitud: String,
    val id_predio: Int,
    val id_servicio: Int,
    val id_solicitante: Int,
    val id_solicitud: Int,
    val nombre_solicitante: String,
    val num_casas: Int
)