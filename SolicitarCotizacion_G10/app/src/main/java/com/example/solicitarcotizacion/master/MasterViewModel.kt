package com.example.solicitarcotizacion.master

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.PredioItem

class MasterViewModel : ViewModel() {
    private val _personaName = MutableLiveData<String>()
    val personaName : LiveData<String> = _personaName

    fun setPersonaName(name: String){
        _personaName.value = name
    }

    private val _personaID = MutableLiveData<Int>()
    val personaID : LiveData<Int> = _personaID

    fun setPersonaId(id: Int){
        _personaID.value = id
    }

    private val _cSeguridad = MutableLiveData<Boolean>()
    val cSeguridad : LiveData<Boolean> = _cSeguridad

    fun setSeguridad(seg: Boolean){
        _cSeguridad.value = seg
    }

    private val _cLimpieza = MutableLiveData<Boolean>()
    val cLimpieza : LiveData<Boolean> = _cLimpieza

    fun setLimpieza(limp: Boolean){
        _cLimpieza.value = limp
    }

    private val _cJardineria = MutableLiveData<Boolean>()
    val cJardineria : LiveData<Boolean> = _cJardineria

    fun setJardineria(jar: Boolean){
        _cJardineria.value = jar
    }

    private val _predioSelected = MutableLiveData<PredioItem>()
    val predioSelected : LiveData<PredioItem> = _predioSelected

    fun selectPredio(pred: PredioItem){
        _predioSelected.value = pred
    }

    private val _cantAdmin = MutableLiveData<String>()
    val cantAdmin : LiveData<String> = _cantAdmin

    fun setCantAdmin(cant: String){
        _cantAdmin.value = cant
    }

    private val _cantSeguridad = MutableLiveData<String>()
    val cantSeguridad : LiveData<String> = _cantSeguridad

    fun setCantSeguridad(cant: String){
        _cantSeguridad.value = cant
    }

    private val _cantLimpieza = MutableLiveData<String>()
    val cantLimpieza : LiveData<String> = _cantLimpieza

    fun setCantLimpieza(cant: String){
        _cantLimpieza.value = cant
    }

    private val _cantJardineria = MutableLiveData<String>()
    val cantJardineria : LiveData<String> = _cantJardineria

    fun setCantJardineria(cant: String){
        _cantJardineria.value = cant
    }
}