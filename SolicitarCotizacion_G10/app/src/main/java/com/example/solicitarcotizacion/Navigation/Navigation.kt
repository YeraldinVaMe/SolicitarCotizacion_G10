package com.example.solicitarcotizacion.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.master.MasterViewModel
import com.example.solicitarcotizacion.ui.AgregarAreasComunes.AgregarAreasComunes
import com.example.solicitarcotizacion.ui.AgregarAreasComunes.AgregarAreasComunesViewModel
import com.example.solicitarcotizacion.ui.AgregarPredio.AgregarPredioS
import com.example.solicitarcotizacion.ui.AgregarPredio.AgregarPredioViewModel
import com.example.solicitarcotizacion.ui.CatalogoServicios.CatalogoServicioViewModel
import com.example.solicitarcotizacion.ui.CatalogoServicios.CatalogoServicios
import com.example.solicitarcotizacion.ui.Login.Login
import com.example.solicitarcotizacion.ui.Login.LoginViewModel
import com.example.solicitarcotizacion.ui.MenuPrincipal.MenuPrincipal
import com.example.solicitarcotizacion.ui.Register.Register
import com.example.solicitarcotizacion.ui.Register.RegisterViewModel
import com.example.solicitarcotizacion.ui.Resumen.Resumen
import com.example.solicitarcotizacion.ui.Resumen.ResumenViewModel
import com.example.solicitarcotizacion.ui.VerAreasComunes.VerAreasComunes
import com.example.solicitarcotizacion.ui.VerAreasComunes.VerAreasComunesViewModel
import com.example.solicitarcotizacion.ui.VerPredio.VerPredio
import com.example.solicitarcotizacion.ui.VerPredio.VerPredioViewModel
import com.example.solicitarcotizacion.ui.solicitarCotizacion.SolicitarCotizacion
import com.example.solicitarcotizacion.ui.solicitarCotizacion.SolicitarCotizacionViewModel

@Composable
fun Navigation(){
    val masterViewModel = remember{ MasterViewModel()}
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route){
            Login(navController = navController, LoginViewModel(), masterViewModel)
        }
        composable(route = Screen.Register.route){
            Register(navController = navController, RegisterViewModel(), masterViewModel)
        }
        composable(route = Screen.MenuPrincipal.route){
            MenuPrincipal(navController = navController, masterViewModel)  // ---------------
        }
        composable(route = Screen.CatalogoServicios.route){
            CatalogoServicios(navController = navController, CatalogoServicioViewModel(), masterViewModel)
        }
        composable(route = Screen.AgregarAreasComunes.route){
            AgregarAreasComunes(navController = navController, AgregarAreasComunesViewModel(), masterViewModel)
        }
        composable(route = Screen.AgregarPredio.route){
            AgregarPredioS(navController = navController, AgregarPredioViewModel(), masterViewModel)
        }
        composable(route = Screen.Resumen.route){
            Resumen(navController = navController, ResumenViewModel(), masterViewModel)
        }
        composable(route = Screen.solicitarCotizacion.route){
            SolicitarCotizacion(navController = navController, SolicitarCotizacionViewModel(), masterViewModel)
        }
        composable(route = Screen.VerAreasComunes.route){
            VerAreasComunes(navController = navController, VerAreasComunesViewModel(), masterViewModel)
        }
        composable(route = Screen.VerPredio.route){
            VerPredio(navController = navController, VerPredioViewModel(), masterViewModel)
        }
    }
}