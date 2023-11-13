package com.example.solicitarcotizacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Navigation
import com.example.solicitarcotizacion.ui.AgregarAreasComunes.AgregarAreasComunes
import com.example.solicitarcotizacion.ui.AgregarPredio.AgregarPredio
import com.example.solicitarcotizacion.ui.Register.Register
import com.example.solicitarcotizacion.ui.Register.RegisterViewModel
import com.example.solicitarcotizacion.ui.Resumen.Resumen
import com.example.solicitarcotizacion.ui.VerAreasComunes.VerAreasComunes
import com.example.solicitarcotizacion.ui.VerPredio.VerPredio
import com.example.solicitarcotizacion.ui.solicitarCotizacion.SolicitarCotizacion
import com.example.solicitarcotizacion.ui.theme.SolicitarCotizacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolicitarCotizacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun mainPreview(){
    SolicitarCotizacionTheme {
        Register(rememberNavController(), RegisterViewModel())
    }
}