package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Servicio
import com.example.solicitarcotizacion.data.repository.ServicioRepository

class ServicioUseCase {
    private val repository = ServicioRepository()

    suspend fun getServicioUC(): Result<Servicio> {
        return repository.getServicioRepository()
    }
}
