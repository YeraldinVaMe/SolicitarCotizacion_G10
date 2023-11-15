package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.TipoPredio
import com.example.solicitarcotizacion.data.repository.TipoPredioRepository

class TipoPredioUseCase {
    private val repository = TipoPredioRepository()

    suspend fun getTipoPredioUC(): Result<TipoPredio> {
        return repository.getTipoPredioRepository()
    }
}
