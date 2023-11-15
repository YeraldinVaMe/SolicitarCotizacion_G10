package com.example.solicitarcotizacion.ui.AgregarPredio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AgregarPredioViewModel (){
    //  ----------------------Nombre Predio -----------------------
    private val _nombres = MutableLiveData<String>()
    val nombres: LiveData<String> = _nombres
    fun onNombresChange(nombres: String) {
        _nombres.value = nombres
    }
    // -------------------------- RUC  ----------------------------
    private val _numRUC = MutableLiveData<String>()
    val numRUC: LiveData<String> = _numRUC
    fun onNumRUCChange(numRUC: String) {
        _numRUC.value = numRUC
    }
    // --------------------- Tipo Predio ---------------------------



    // --------------------- Código Postal --------------------------


    // -------------------- Numero de contacto ----------------------
    private val _numContacto= MutableLiveData<String>()
    val numContacto: LiveData<String> = _numContacto
    fun onnumContactoChange(numContacto: String) {
        _numContacto.value = numContacto
    }
    //  -------------------------- Correo ---------------------------
    private val _correo= MutableLiveData<String>()
    val correo: LiveData<String> = _correo
    fun onCorreoChange(correo: String) {
        _correo.value = correo
    }
    //  ------------------------Direccion  -------------------------
    private val _direccion= MutableLiveData<String>()
    val direccion: LiveData<String> = _direccion
    fun onDireccionChange(direccion: String) {
        _direccion.value = direccion
    }
}