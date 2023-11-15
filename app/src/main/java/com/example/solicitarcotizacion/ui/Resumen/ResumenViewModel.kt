package com.example.solicitarcotizacion.ui.Resumen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ResumenViewModel (){
    //  ----------------------N° SOLICITUD  -----------------------
    private var inputSolicitudtext : String = ""
    fun getInputSolicitudtext() : String{
        inputSolicitudtext = "98"
        return inputSolicitudtext
    }

    //  ----------------NOMBRE DEL SOLICITANTE --------------------
    private var inputNombreSolicitantetext : String = ""
    fun getInputNombreSolicitantetext() : String{
        inputNombreSolicitantetext = "Ricardo G."
        return inputNombreSolicitantetext
    }

    //  ------------------- FECHA DE SOLICITUD---------------------
    private var inputFechatext : String = ""
    fun getInputFechatext() : String{
        inputFechatext = "14/11/2023"
        return inputFechatext
    }

    //  ------------------- NOMBRE PREDIO   -----------------------
    private var inputNombrePrediotext : String = ""
    fun getInputNombrePrediotext() : String{
        inputNombrePrediotext = "Los Tucanes"
        return inputNombrePrediotext
    }

    //  --------------------- AREA PREDIO   -----------------------
    private var inputAreaPrediotext : String = ""
    fun getInputAreaPrediotext() : String{
        inputAreaPrediotext = "150 m²"
        return inputAreaPrediotext
    }

    //  ----------------------N° CASAS      -----------------------
    private var inputNumeroCasastext : String = ""
    fun getInputNumeroCasastext() : String{
        inputNumeroCasastext = "15"
        return inputNumeroCasastext
    }

    //  -------------------TOTAL AREA COMUN -----------------------
    private var inputAreasComunestext : String = ""
    fun getInputAreasComunestext() : String{
        inputAreasComunestext = "380.4 m² total (4)"
        return inputAreasComunestext
    }

    //  --------------- SERVICIO SOLICITADO -----------------------
    private var inputServicioSolicitadotext : String = ""
    fun getInputServicioSolicitadotext() : String{
        inputServicioSolicitadotext = "Administracion (1), Seguridad(2), Limpieza (2), Jardineria(3)"
        return inputServicioSolicitadotext
    }
}