package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Ubigeo
import com.example.solicitarcotizacion.data.repository.UbigeoRepository

class UbigeoUseCase {
    private val repository = UbigeoRepository()

    suspend fun getUbigeoUC(): Result<Ubigeo> {
        return repository.getUbigeoRepository()
    }
}
