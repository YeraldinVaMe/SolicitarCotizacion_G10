package com.example.solicitarcotizacion.data.model

data class PredioItem(
    val correo: String,
    val descripcion: String,
    val direccion: String,
    val id_persona: Int,
    val id_predio: Int,
    val id_tipo_predio: Int,
    val idubigeo: String,
    val ruc: String,
    val telefono: String
)