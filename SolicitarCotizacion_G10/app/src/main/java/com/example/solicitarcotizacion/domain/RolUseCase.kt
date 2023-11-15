package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Rol
import com.example.solicitarcotizacion.data.repository.RolRepository

class RolUseCase {
    private val repository = RolRepository()

    suspend fun getRolUC(): Result<Rol> {
        return repository.getRolRepository()
    }
}
