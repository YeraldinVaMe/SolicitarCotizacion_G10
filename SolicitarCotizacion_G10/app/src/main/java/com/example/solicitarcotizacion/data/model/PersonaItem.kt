package com.example.solicitarcotizacion.data.model

data class PersonaItem(
    val apellido_materno: String,
    val apellido_paterno: String,
    val direccion: String,
    val fecha_nacimiento: String,
    val id_persona: Int,
    val id_tipo_documento: Int,
    val idubigeo: String,
    val ndocumento: String,
    val nombres: String
)