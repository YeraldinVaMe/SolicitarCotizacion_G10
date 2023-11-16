package com.example.solicitarcotizacion.ui.VerAreasComunes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VerAreasComunesViewModel (){
    //  ----------------------Area Predio -----------------------
    private val _areaPredio = MutableLiveData<String>()
    val areaPredio: LiveData<String> = _areaPredio
    fun onAreaPredioChange(areaPredio: String) {
        _areaPredio.value = areaPredio
    }
    //  ---------------------Numero Casas -----------------------
    private val _nroCasas = MutableLiveData<String>()
    val nroCasas: LiveData<String> = _nroCasas
    fun onNroCasasChange(nroCasas: String) {
        _nroCasas.value = nroCasas
    }
    //  ----------------- Tipo Area Comun -----------------------
    private val _inputTipoAreaAuxxtext = MutableLiveData<String>()
    val inputTipoAreaAuxxtext: LiveData<String> = _inputTipoAreaAuxxtext


    //  ---------------------  Area comun  -----------------------
    private val _inputAreaAuxxtext = MutableLiveData<String>()
    val inputAreaAuxxtext: LiveData<String> = _inputAreaAuxxtext

    //  ---------------------  Area comun  -----------------------
    private var inputCantidadAreatext : String = ""
    fun getInputCantidadAreaText() : String{
        inputCantidadAreatext = "2"
        return inputCantidadAreatext
    }
}