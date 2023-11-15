package com.example.solicitarcotizacion.Navigation

sealed class Screen(val route: String){
    object Login: Screen("login_screen")
    object Register: Screen("Register_screen")
    object CatalogoServicios: Screen("CatalogoServicios_screen")
    object MenuPrincipal: Screen("MenuPrincipal_screen")
    object AgregarAreasComunes: Screen("AgregarAreasComunes_screen")
    object AgregarPredio: Screen("AgregarPredio_screen")
    object Resumen: Screen("Resumen_screen")
    object solicitarCotizacion: Screen("solicitarCotizacion_screen")
    object VerAreasComunes: Screen("VerAreasComunes_screen")
    object VerPredio: Screen("VerPredio_screen")
}
