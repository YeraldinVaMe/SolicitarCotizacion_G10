package com.example.solicitarcotizacion.ui.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
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

    private val _list = MutableLiveData<List<String>>()
    val list : LiveData<List<String>> = _list

}