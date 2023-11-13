package com.example.solicitarcotizacion.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.ui.AgregarAreasComunes.AgregarAreasComunes
import com.example.solicitarcotizacion.ui.AgregarPredio.AgregarPredioS
import com.example.solicitarcotizacion.ui.CatalogoServicios.CatalogoServicios
import com.example.solicitarcotizacion.ui.Login.Login
import com.example.solicitarcotizacion.ui.Login.LoginViewModel
import com.example.solicitarcotizacion.ui.MenuPrincipal.MenuPrincipal
import com.example.solicitarcotizacion.ui.Register.Register
import com.example.solicitarcotizacion.ui.Resumen.Resumen
import com.example.solicitarcotizacion.ui.VerAreasComunes.VerAreasComunes
import com.example.solicitarcotizacion.ui.VerPredio.VerPredio
import com.example.solicitarcotizacion.ui.solicitarCotizacion.SolicitarCotizacion

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route){
            Login(navController = navController, LoginViewModel())
        }
        composable(route = Screen.Register.route){
            Register(navController = navController)
        }
        composable(route = Screen.MenuPrincipal.route){
            MenuPrincipal(navController = navController)
        }
        composable(route = Screen.CatalogoServicios.route){
            CatalogoServicios(navController = navController)
        }
        composable(route = Screen.AgregarAreasComunes.route){
            AgregarAreasComunes(navController = navController)
        }
        composable(route = Screen.AgregarPredio.route){
            AgregarPredioS(navController = navController)
        }
        composable(route = Screen.Resumen.route){
            Resumen(navController = navController)
        }
        composable(route = Screen.solicitarCotizacion.route){
            SolicitarCotizacion(navController = navController)
        }
        composable(route = Screen.VerAreasComunes.route){
            VerAreasComunes(navController = navController)
        }
        composable(route = Screen.VerPredio.route){
            VerPredio(navController = navController)
        }
    }
}