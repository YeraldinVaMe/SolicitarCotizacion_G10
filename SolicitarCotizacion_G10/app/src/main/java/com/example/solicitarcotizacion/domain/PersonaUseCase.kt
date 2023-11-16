package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Persona
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.PredioItem
import com.example.solicitarcotizacion.data.repository.PersonaRepository

class PersonaUseCase {
    private val repository = PersonaRepository()

    suspend fun getPersonasUC(): Result<Persona> {
        return repository.getPersonasRepository()
    }

    suspend fun createPersonaUC(personaItem: PersonaItem): Result<Unit> {
        return repository.createPersonaRepository(personaItem)
    }

    suspend fun getIdPersona(): Int?{
        return repository.obtenerId()
    }
}
