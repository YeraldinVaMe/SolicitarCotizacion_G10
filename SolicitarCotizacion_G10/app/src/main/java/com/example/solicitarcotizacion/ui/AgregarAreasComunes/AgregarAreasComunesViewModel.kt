package com.example.solicitarcotizacion.ui.AgregarAreasComunes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AgregarAreasComunesViewModel (){
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


    //  ---------------------  Area comun  -----------------------
    private val _areaComun = MutableLiveData<String>()
    val areaComun: LiveData<String> = _areaComun
    fun onAreaComunChange(areaComun: String) {
        _areaComun.value = areaComun
    }
    //  ---------------------  Area comun  -----------------------
    private val _inputCantAreas = MutableLiveData<String>()
    val inputCantAreas: LiveData<String> = _inputCantAreas
}
