package com.example.solicitarcotizacion.ui.Register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel(){

    //  ------------------Tipo de Documento -----------------------
    /*private val _list = MutableLiveData<List<String>>()
    val list : LiveData<List<String>> = _list*/


    // ------------------ Numero de Documento  --------------------
    private val _numDoc = MutableLiveData<String>()
    val numDoc: LiveData<String> = _numDoc
    fun onNumDocChange(numDoc: String) {
        _numDoc.value = numDoc
    }
    // ------------------------ Nombres ---------------------------
    private val _nombres = MutableLiveData<String>()
    val nombres: LiveData<String> = _nombres
    fun onNombresChange(nombres: String) {
        _nombres.value = nombres
    }
    //  ------------------------ Apellidos  ------------------------
    private val _apellidos= MutableLiveData<String>()
    val apellidos: LiveData<String> = _apellidos
    fun onApellidosChange(apellidos: String) {
        _apellidos.value = apellidos
    }
    // ------------------------ Fecha Nac --------------------------
    private val _fechaNacimiento = MutableLiveData("Seleccione una fecha")
    val fechaNacimiento: LiveData<String> = _fechaNacimiento
    fun onFechaNacimientoChange(fecha: String) {
        _fechaNacimiento.value = fecha
    }
    // ------------------------ Codigo Postal ----------------------


    //  ------------------------Direccion  -------------------------
    private val _direccion= MutableLiveData<String>()
    val direccion: LiveData<String> = _direccion
    fun onDireccionChange(direccion: String) {
        _direccion.value = direccion
    }
    //  -------------------------- Correo ---------------------------
    private val _correo= MutableLiveData<String>()
    val correo: LiveData<String> = _correo
    fun onCorreoChange(correo: String) {
        _correo.value = correo
    }
}