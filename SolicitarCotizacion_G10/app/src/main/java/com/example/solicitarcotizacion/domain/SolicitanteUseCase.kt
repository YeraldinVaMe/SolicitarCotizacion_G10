package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.Solicitante
import com.example.solicitarcotizacion.data.model.SolicitanteItem
import com.example.solicitarcotizacion.data.repository.SolicitanteRepository

class SolicitanteUseCase {
    private val repository = SolicitanteRepository()

    suspend fun getSolicitanteUC(): Result<Solicitante> {
        return repository.getSolicitanteRepository()
    }

    suspend fun createSolicitanteUC(solicitanteItem: SolicitanteItem): Result<Unit> {
        return repository.createSolicitanteRepository(solicitanteItem)
    }
}
