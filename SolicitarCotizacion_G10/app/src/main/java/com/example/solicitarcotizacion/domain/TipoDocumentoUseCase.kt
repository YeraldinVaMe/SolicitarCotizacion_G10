package com.example.solicitarcotizacion.domain

import com.example.solicitarcotizacion.data.model.TipoDocumento
import com.example.solicitarcotizacion.data.repository.TipoDocumentoRepository

class TipoDocumentoUseCase {
    private val repository = TipoDocumentoRepository()

    suspend fun getTipoDocumentoUC(): Result<TipoDocumento> {
        return repository.getTipoDocumentoRepository()
    }
}
