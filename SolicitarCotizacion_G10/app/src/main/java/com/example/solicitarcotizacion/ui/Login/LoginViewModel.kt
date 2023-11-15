package com.example.solicitarcotizacion.ui.Login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solicitarcotizacion.data.model.Persona
import com.example.solicitarcotizacion.data.model.PersonaItem
import com.example.solicitarcotizacion.data.model.Predio
import com.example.solicitarcotizacion.data.model.Solicitante
import com.example.solicitarcotizacion.domain.PersonaUseCase
import com.example.solicitarcotizacion.domain.SolicitanteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel(){

    private val personaUseCase = PersonaUseCase()
    private val solicitanteUseCase = SolicitanteUseCase()

    private val _personasResult = MutableStateFlow(Persona())
    val personasResult = _personasResult.asStateFlow()

    private val _solicitantesResult = MutableStateFlow(Solicitante())
    val solicitantesResult = _solicitantesResult.asStateFlow()

    init {
        getPersonas()
        getSolicitantes()
    }

    private fun getPersonas(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = personaUseCase.getPersonasUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                        _personasResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining persona")
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR2", "Error obtaining persona", e)
                withContext(Dispatchers.Main) {
                }
            }
        }
    }

    private fun getSolicitantes(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = solicitanteUseCase.getSolicitanteUC()
                withContext(Dispatchers.Main) {
                    result.onSuccess {
                       _solicitantesResult.value = it
                    }
                    result.onFailure {
                        Log.e("ERROR1", "Error obtaining solicitante")
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR2", "Error obtaining solicitante", e)
                withContext(Dispatchers.Main) {
                }
            }
        }
    }

    fun iniciarSesion(){
        val solicitante = _solicitantesResult.value.firstOrNull  {
            sol -> sol.correo == _correo.value
        }
        if(solicitante != null){
            val persona = _personasResult.value.firstOrNull {
                per -> per.id_persona == solicitante.id_persona
            }
            if(persona != null){
                if(persona.ndocumento == _pass.value){
                    _personaName.value = persona.nombres + " " + persona.apellido_paterno + " " + persona.apellido_materno
                    _personaId.value = persona.id_persona
                    _access.value = true
                }else{
                    _showDialog.value = true
                }
            }else{
                _showDialog.value = true
            }
        }else{
            _showDialog.value = true
        }
    }

    fun cerrarDialogo(){
        _showDialog.value = false
    }


    private val _personaName = MutableLiveData<String>()
    val personaName : LiveData<String> = _personaName
    private val _personaId = MutableLiveData<Int>()
    val personaId : LiveData<Int> = _personaId

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog : LiveData<Boolean> = _showDialog

    private val _access = MutableLiveData<Boolean>()
    val access : LiveData<Boolean> = _access

    private val _correo = MutableLiveData<String>()
    val correo : LiveData<String> = _correo
    fun onCorreoChange(correo: String){
        _correo.value = correo
    }
    private val _pass = MutableLiveData<String>()
    val pass : LiveData<String> = _pass
    fun onPassChange(pass: String){
        _pass.value = pass
    }
}