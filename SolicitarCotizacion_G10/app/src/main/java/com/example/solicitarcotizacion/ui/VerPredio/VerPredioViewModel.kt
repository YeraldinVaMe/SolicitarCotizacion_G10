package com.example.solicitarcotizacion.ui.VerPredio
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class VerPredioViewModel (){
    //  ----------------------Nombre Predio -----------------------
    private var inputContenedorNombrePrediotext : String = ""
    fun getInputContenedorNombrePredio(): String {
        inputContenedorNombrePrediotext = "Los Tucanes"
        return inputContenedorNombrePrediotext
    }

    // -------------------------- RUC  ----------------------------
    private var inputContenedorRUCtext : String = ""
    fun getInputContenedorRUCtext(): String {
        inputContenedorRUCtext = "789987789456"
        return inputContenedorRUCtext
    }

    // --------------------- Tipo Predio ---------------------------
    private var inputContenedorTipotext : String = ""
    fun getInputContenedorTipotext() : String{
        inputContenedorTipotext = "Condominio"
        return inputContenedorTipotext
    }

    // --------------------- Código Postal --------------------------
    private var inputContenedorCodPostaltext : String = ""
    fun getInputContenedorCodPostaltext() : String{
        inputContenedorCodPostaltext = "1055 Santa Anita"
        return inputContenedorCodPostaltext
    }

    // -------------------- Numero de contacto ----------------------
    private var inputContenedorNumContactotext : String = ""
    fun getInputContenedorNumContactotext() : String{
        inputContenedorNumContactotext = "99551312"
        return inputContenedorNumContactotext
    }

    //  -------------------------- Correo ---------------------------
    private var inputContenedorCorreotext : String = ""
    fun getInputContenedorCorreotext() : String{
        inputContenedorCorreotext = "tucanes@condominio.com"
        return inputContenedorCorreotext
    }

    //  ------------------------Direccion  -------------------------
    private var inputCotenedorDirecciontext : String = ""
    fun getInputCotenedorDirecciontext() : String{
        inputCotenedorDirecciontext = "Avenida Guardia Civil"
        return inputCotenedorDirecciontext
    }
}