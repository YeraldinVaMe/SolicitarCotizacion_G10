package com.example.solicitarcotizacion.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.ui.CatalogoServicios.ui.CatalogoServicios
import com.example.solicitarcotizacion.ui.Login.ui.Login
import com.example.solicitarcotizacion.ui.MenuPrincipal.ui.MenuPrincipal
import com.example.solicitarcotizacion.ui.Register.ui.Register

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route){
            Login(navController = navController)
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
    }
}