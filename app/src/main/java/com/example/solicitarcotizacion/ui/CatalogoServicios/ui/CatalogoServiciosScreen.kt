package com.example.solicitarcotizacion.ui.CatalogoServicios.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.boxadmgeneral.BoxAdmGeneral
import com.example.solicitarcotizacion.boxservespecificos.BoxServEspecificos
import com.example.solicitarcotizacion.descrip.Descrip
import com.example.solicitarcotizacion.titlecs.TitleCs
import com.google.relay.compose.RelayContainer

@Composable
fun CatalogoServicios(navController: NavController) {
    val image = painterResource(R.drawable.fondo2)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer (
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                TitleCs(modifier = Modifier.rowWeight(1.0f))
            }
            RelayContainer (
                Modifier
                    .padding(bottom = 30.dp)
            ){
                Descrip(modifier = Modifier.rowWeight(1.0f))
            }
            RelayContainer(
                Modifier
                    .height(175.dp)
                    .width(355.dp)
                    .padding(bottom = 15.dp)
            ) {
                BoxAdmGeneral(
                    onBtnSeleccionar = {},
                    modifier = Modifier
                        .rowWeight(1.0f)
                        .columnWeight(1.0f)
                )
            }
            RelayContainer(
                Modifier
                    .height(435.dp)
                    .width(355.dp)
            ) {
                BoxServEspecificos(
                    oncheckBoxGuardias = {},
                    oncheckBoxLimpieza = {},
                    oncheckBoxJardineria = {},
                    oncheckBoxAreas = {},
                    modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CatalogoPreview(){
    CatalogoServicios(rememberNavController())
}