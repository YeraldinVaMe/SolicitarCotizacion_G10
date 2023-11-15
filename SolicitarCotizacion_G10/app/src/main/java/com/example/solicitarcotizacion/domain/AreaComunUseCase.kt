package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.AreaComun
import com.example.solicitarcotizacion.data.repository.AreaComunRepository

class AreaComunUseCase {
    private val repository = AreaComunRepository()

    suspend fun getAreaComunUC(): Result<AreaComun>{
        return repository.getAreaComunRepository()
    }
}