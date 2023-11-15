package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Solicitud
import com.example.solicitarcotizacion.data.repository.SolicitudRepository

class SolicitudUseCase {
    private val repository = SolicitudRepository()

    suspend fun getSolicitudUC(): Result<Solicitud> {
        return repository.getSolicitudRepository()
    }
}
