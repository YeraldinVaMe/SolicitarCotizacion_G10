package com.example.solicitarcotizacion.ui.solicitarCotizacion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicitarcotizacion.data.model.Predio
import com.example.solicitarcotizacion.data.model.PredioItem
import com.example.solicitarcotizacion.domain.PredioUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SolicitarCotizacionViewModel: ViewModel (){

    private val obtenerPrediosUseCase = PredioUseCase()

    private val _prediosResult = MutableStateFlow(Predio())
    val prediosResult = _prediosResult.asStateFlow()

    init {
        getPredios()
    }

    private fun getPredios(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = obtenerPrediosUseCase.getPredioUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                        _prediosResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining predios")
                    }
                }
            } catch (e: Exception) {
                Log.e("SolicitarCotizacionVM", "Error obtaining predios", e)
                withContext(Dispatchers.Main) {
                }
            }
        }
    }

    // ID PREDIO

    private val _predioSelected = MutableLiveData<Int>()
    val predioSelected : LiveData<Int> = _predioSelected

    fun selectPredio(idPred: Int){
        _predioSelected.value = idPred
    }

    //  ----------------- NOMBRES COMPLETOS -----------------------
    private var inputNombre : String = ""
    fun getNombre(): String {
        inputNombre = "Ricardo G. Torres"
        return inputNombre
    }

    //  --------------------   ADM GENERAL  -----------------------
    private val _numAdm = MutableLiveData<String>("1")
    val numAdm: LiveData<String> = _numAdm
    fun onNumAdmChange(numAdm: String) {
        _numAdm.value = numAdm
    }

    //  ----------------- GUARDIAS SEGURIDAD ----------------------
    private val _numGuardias = MutableLiveData<String>()
    val numGuardias: LiveData<String> = _numGuardias
    fun onNumGuardiasChange(numGuardias: String) {
        _numGuardias.value = numGuardias
    }
    //  ------------------  SERV. LIMPIEZA  -----------------------
    private val _numLimpieza= MutableLiveData<String>()
    val numLimpieza: LiveData<String> = _numLimpieza
    fun onNumLimpiezaChange(numLimpieza: String) {
        _numLimpieza.value = numLimpieza
    }
    //  --------------------SERV. JARDINERIA   ---------------------
    private val _numJardineria = MutableLiveData<String>()
    val numJardineria: LiveData<String> = _numJardineria
    fun onNumJardineriaChange(numJardineria: String) {
        _numJardineria.value = numJardineria
    }
    //  --------------------     TIPO PREDIO -----------------------

    //  --------------------     READONLY --------------------------
    private var readonlyAdmin : Boolean = false
    private var readonlySeguridad : Boolean = false
    private var readonlyLimpieza : Boolean = false
    private var readonlyJardin : Boolean = false
    fun getReadonlyAdmin(): Boolean {
        readonlyAdmin = true
        return readonlyAdmin
    }
    fun getReadonlySeguridad(): Boolean {
        readonlySeguridad = false
        return readonlySeguridad
    }
    fun getReadonlyLimpieza(): Boolean {
        readonlyLimpieza = false
        return readonlyLimpieza
    }
    fun getReadonlyJardin(): Boolean {
        readonlyJardin = false
        return readonlyJardin
    }

}