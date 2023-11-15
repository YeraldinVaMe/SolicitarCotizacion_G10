package com.example.solicitarcotizacion.ui.CatalogoServicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogoServicioViewModel: ViewModel(){
    // ------------------ Guardias  --------------------
    private val _oncheckBoxGuardias= MutableLiveData<Boolean>()
    val oncheckBoxGuardias: LiveData<Boolean> = _oncheckBoxGuardias
    fun onOncheckBoxGuardiasChange(oncheckBoxGuardias: Boolean) {
        _oncheckBoxGuardias.value = oncheckBoxGuardias
    }

    // ------------------ Limpieza  --------------------

    private val _oncheckBoxLimpieza= MutableLiveData<Boolean>()
    val oncheckBoxLimpieza: LiveData<Boolean> = _oncheckBoxLimpieza
    fun onOncheckBoxLimpieza(oncheckBoxLimpieza: Boolean) {
        _oncheckBoxLimpieza.value = oncheckBoxLimpieza
    }
    // ------------------ Jardineria  --------------------

    private val _oncheckBoxJardineria= MutableLiveData<Boolean>()
    val oncheckBoxJardineria: LiveData<Boolean> = _oncheckBoxJardineria
    fun onnOncheckBoxJardineriaChange(oncheckBoxJardineria: Boolean) {
        _oncheckBoxJardineria.value = oncheckBoxJardineria
    }
    // ------------------   Areas     --------------------
    private val _oncheckBoxAreas= MutableLiveData<Boolean>()
    val oncheckBoxAreas: LiveData<Boolean> = _oncheckBoxAreas
    fun onOncheckBoxAreasChange(numContacto: Boolean) {
        _oncheckBoxAreas.value = numContacto
    }

    // --------------   Funciones Auxiliares  --------------------
    fun SeleccionarTodo(){
        _oncheckBoxGuardias.value = true
        _oncheckBoxLimpieza.value = true
        _oncheckBoxJardineria.value = true
        _oncheckBoxAreas.value = true
    }
}