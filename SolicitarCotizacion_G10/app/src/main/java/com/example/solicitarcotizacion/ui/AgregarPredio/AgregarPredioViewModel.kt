package com.example.solicitarcotizacion.ui.AgregarPredio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicitarcotizacion.data.model.PredioItem
import com.example.solicitarcotizacion.data.model.TipoPredio
import com.example.solicitarcotizacion.data.model.Ubigeo
import com.example.solicitarcotizacion.domain.PredioUseCase
import com.example.solicitarcotizacion.domain.TipoPredioUseCase
import com.example.solicitarcotizacion.domain.UbigeoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AgregarPredioViewModel: ViewModel (){

    private val predioUseCase = PredioUseCase()
    private val obtenerTipoPredio = TipoPredioUseCase()
    private val obtenerUbigeo = UbigeoUseCase()

    private val _tipoPredioResult = MutableStateFlow(TipoPredio())
    val tipoPredioResult = _tipoPredioResult.asStateFlow()

    private val _ubigeoResult = MutableStateFlow(Ubigeo())
    val ubigeoResult = _ubigeoResult.asStateFlow()

    init {
        getTipoPredio()
        getUbigeo()
    }

    private fun getTipoPredio(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = obtenerTipoPredio.getTipoPredioUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                        _tipoPredioResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining TipoPredios")
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR2", "Error obtaining TipoPredios", e)
                withContext(Dispatchers.Main) {
                }
            }
        }
    }

    private fun getUbigeo(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = obtenerUbigeo.getUbigeoUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                        _ubigeoResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining ubigeo")
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR2", "Error obtaining ubigeo", e)
                withContext(Dispatchers.Main) {
                }
            }
        }
    }

    fun agregarPredio(){


        viewModelScope.launch(Dispatchers.IO) {
            try {
                val predioItem = PredioItem(
                    correo = _correo.value ?: "",
                    descripcion = _nombres.value ?: "",
                    direccion = _direccion.value ?: "",
                    id_persona = id_persona,
                    id_predio = 0,
                    id_tipo_predio = tipPredioSelected,
                    idubigeo = ubigeoSelected,
                    ruc = _numRUC.value ?: "",
                    telefono = _numContacto.value ?: "",
                )

                val result = predioUseCase.createPredioUC(predioItem)
                withContext(Dispatchers.Main){
                    result.onSuccess {
                        Log.d("SUCCESS1", "Se agregó el predio")
                        _showDialog.value = true
                        _showDialog2.value = false
                    }
                    result.onFailure {
                        _showDialog.value = false
                        _showDialog2.value = true
                        Log.e("ERROR1", "Error al registrar el predio")
                    }
                }
            }catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _showDialog.value = false
                    _showDialog2.value = true
                    Log.e("ERROR2", "Error al registrar el predio")
                }
            }
        }
    }

    fun reiniciarDialogos(){
        _showDialog.value = false
        _showDialog2.value = false
    }
    //OTROS

    var tipPredioSelected : Int = 0
    var ubigeoSelected: String = ""
    val id_persona : Int = 32
    //var showDialog: Boolean = false

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _showDialog2 = MutableLiveData<Boolean>()
    val showDialog2: LiveData<Boolean> = _showDialog2

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