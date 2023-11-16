package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Predio
import com.example.solicitarcotizacion.data.model.PredioItem
import com.example.solicitarcotizacion.data.repository.PredioRepository

class PredioUseCase {
    private val repository = PredioRepository()

    suspend fun getPredioUC(): Result<Predio> {
        return repository.getPredioRepository()
    }

    suspend fun createPredioUC(predioItem: PredioItem): Result<Unit> {
        return repository.createPredioRepository(predioItem)
    }
}
