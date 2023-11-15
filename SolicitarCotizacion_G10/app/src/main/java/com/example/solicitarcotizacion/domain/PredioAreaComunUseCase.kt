package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.PredioAreaComun
import com.example.solicitarcotizacion.data.repository.PredioAreaComunRepository

class PredioAreaComunUseCase {
    private val repository = PredioAreaComunRepository()

    suspend fun getPredioAreaComunUC(): Result<PredioAreaComun> {
        return repository.getPredioAreaComunRepository()
    }
}
