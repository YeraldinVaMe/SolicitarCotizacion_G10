package com.example.solicitarcotizacion.ui.MenuPrincipal

import ComponentesModificados.descripBien.descripBien
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.btncatalogo.BtnCatalogo
import com.example.solicitarcotizacion.btnsalir.BtnSalir
import com.example.solicitarcotizacion.btnsolicitar.BtnSolicitar
import com.example.solicitarcotizacion.condosa1.Condosa1
import com.google.relay.compose.RelayContainer

@Composable
fun MenuPrincipal(navController: NavController){
    val image = painterResource(R.drawable.fondo3)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
        ){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                RelayContainer(
                ) {
                    BtnSalir(
                        onBtnSalirtapped = {navController.navigate(Screen.Login.route)},
                        modifier = Modifier
                            .rowWeight(1.0f)
                            .width(128.dp)

                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                RelayContainer {
                    Condosa1(modifier = Modifier.rowWeight(1.0f))
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                descripBien()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),
                horizontalArrangement = Arrangement.Center
            ){
                RelayContainer(
                ) {
                    BtnCatalogo(
                        onBtnCatalogtapped = {navController.navigate(Screen.CatalogoServicios.route)},
                        modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                            .width(161.dp)
                            .height(165.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                RelayContainer(
                ) {
                    BtnSolicitar(
                        onBtnSolicitartapped = {navController.navigate(Screen.solicitarCotizacion.route)},
                        modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                            .width(161.dp)
                            .height(165.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun MenuPrincipalPreview(){
    MenuPrincipal(rememberNavController())
}