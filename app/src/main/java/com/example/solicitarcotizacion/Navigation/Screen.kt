package com.example.solicitarcotizacion.Navigation

sealed class Screen(val route: String){
    object Login: Screen("login_screen")
    object Register: Screen("Register_screen")
    object CatalogoServicios: Screen("CatalogoServicios_screen")
    object MenuPrincipal: Screen("MenuPrincipal_screen")
}
