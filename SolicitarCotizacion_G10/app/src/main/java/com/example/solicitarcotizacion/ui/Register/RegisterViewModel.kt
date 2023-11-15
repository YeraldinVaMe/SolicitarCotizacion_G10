package com.example.solicitarcotizacion.ui.Register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.SolicitanteItem
import com.example.solicitarcotizacion.data.model.TipoDocumento
import com.example.solicitarcotizacion.data.model.Ubigeo
import com.example.solicitarcotizacion.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel: ViewModel(){
    private val personaUseCase = PersonaUseCase()
    private val solicitanteUseCase = SolicitanteUseCase()
    private val obtenerTipoDocumento = TipoDocumentoUseCase()
    private val obtenerUbigeo = UbigeoUseCase()

    private val _tipoDocumentoResult = MutableStateFlow(TipoDocumento())
    val tipoDocumentoResult = _tipoDocumentoResult.asStateFlow()

    private val _ubigeoResult = MutableStateFlow(Ubigeo())
    val ubigeoResult = _ubigeoResult.asStateFlow()

    init {
        getTipoDocumento()
        getUbigeo()
    }

    private fun getTipoDocumento(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = obtenerTipoDocumento.getTipoDocumentoUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                        _tipoDocumentoResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining TipoDocumento")
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR2", "Error obtaining TipoDocumento", e)
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

    //SELECTED

    var tipoDocumentoSelected : Int = 0
    var ubigeoSelected : String = ""

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

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _showDialog2 = MutableLiveData<Boolean>()
    val showDialog2: LiveData<Boolean> = _showDialog2

    fun agregarSolicitante(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val solicitanteItem = SolicitanteItem(
                    correo = _correo.value?:"",
                    id_persona = 0,/////Tomar el id de persona
                    id_rol = 1,
                    id_solicitante = 0,
                    telefono = 0
                )

                val result = solicitanteUseCase.createSolicitanteUC(solicitanteItem)
                withContext(Dispatchers.Main){
                    result.onSuccess {
                        Log.d("SUCCESS1", "Se agregó el solicitante")
                        _showDialog.value = true
                        _showDialog2.value = false
                    }
                    result.onFailure {
                        _showDialog.value = false
                        _showDialog2.value = true
                        Log.e("ERROR1", "Error al registrar el solicitante")
                    }
                }
            }catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _showDialog.value = false
                    _showDialog2.value = true
                    Log.e("ERROR2", "Error al registrar el solicitante")
                }
            }
        }
    }

    fun agregarPersona(){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apellidos = _apellidos.value?:""
                val split = apellidos.split(" ")
                val personaItem = PersonaItem(
                    apellido_materno = if (split.isNotEmpty()) split[0] else "",
                    apellido_paterno = if (split.size > 1) split[1] else "",
                    direccion = _direccion.value?:"",
                    fecha_nacimiento = _fechaNacimiento.value?:"",
                    id_persona = 0,
                    id_tipo_documento = tipoDocumentoSelected,
                    idubigeo = ubigeoSelected,
                    ndocumento = _numDoc.value ?:"",
                    nombres = _nombres.value ?: ""
                )

                val result = personaUseCase.createPersonaUC(personaItem)
                withContext(Dispatchers.Main){
                    result.onSuccess {
                        Log.d("SUCCESS1", "Se agregó el persona")
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
}