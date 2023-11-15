package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.Personal
import com.example.solicitarcotizacion.data.repository.PersonalRepository

class PersonalUseCase {
    private val repository = PersonalRepository()

    suspend fun getPersonalUC(): Result<Personal>{
        return repository.getPersonalRepository()
    }
}
