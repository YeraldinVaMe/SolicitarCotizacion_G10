package com.example.solicitarcotizacion.ui.VerPredio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.cardprincipalinfoprediovaux.poppins
import com.example.solicitarcotizacion.titulo12principal.Titulo12principal
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun VerPredio(navController: NavController, viewModel: VerPredioViewModel){
    val image = painterResource(R.drawable.fondo2)

    val NombrePrediotext : String = viewModel.getInputContenedorNombrePredio()
    val RUCtext : String = viewModel.getInputContenedorRUCtext()
    val Tipotext : String = viewModel.getInputContenedorTipotext()
    val CodPostaltext : String = viewModel.getInputContenedorCodPostaltext()
    val NumContactotext : String = viewModel.getInputContenedorNumContactotext()
    val Correotext : String = viewModel.getInputContenedorCorreotext()
    val Direcciontext : String = viewModel.getInputCotenedorDirecciontext()

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
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer(
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Titulo12principal(
                    onBack13 = {navController.navigate(Screen.solicitarCotizacion.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }

            RelayContainer {
                CardPrincipalInfoPrediovAux(
                    onBtnSiguiente = {navController.navigate(Screen.VerAreasComunes.route)},
                    onBtnVolverAux = {navController.navigate(Screen.solicitarCotizacion.route)},
                    inputContenedorNombrePrediotext = NombrePrediotext,
                    inputContenedorRUCtext = RUCtext,
                    inputContenedorTipotext = Tipotext,
                    inputContenedorCodPostaltext = CodPostaltext,
                    inputContenedorNumContactotext = NumContactotext,
                    inputContenedorCorreotext = Correotext,
                    inputCotenedorDirecciontext = Direcciontext,
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun VerPredioView(){
    MaterialTheme {
        VerPredio(rememberNavController(), VerPredioViewModel())
    }
}

//CARD INFORMACIÓN PREDIO
@Composable
fun CardPrincipalInfoPrediovAux(
    modifier: Modifier = Modifier,
    inputContenedorNombrePrediotext: String = "",
    inputContenedorRUCtext: String = "",
    inputContenedorTipotext: String = "",
    inputContenedorCodPostaltext: String = "",
    inputContenedorNumContactotext: String = "",
    inputContenedorCorreotext: String = "",
    inputCotenedorDirecciontext: String = "",
    onBtnSiguiente: () -> Unit = {},
    onBtnVolverAux: () -> Unit = {}

) {
    TopLevel(modifier = modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            item {
                InformaciNDelPredio()
                SubCardInforPredio {
                    NombreDelPredio()
                    ContenedorNombrePredio {
                        InputContenedorNombrePredio(inputContenedorNombrePrediotext = inputContenedorNombrePrediotext)
                    }
                    RUC()
                    ContenedorRUC {
                        InputContenedorRUC(inputContenedorRUCtext = inputContenedorRUCtext)
                    }
                    TIpo()
                    ContenedorTipo {
                        InputContenedorTipo(inputContenedorTipotext = inputContenedorTipotext)
                    }
                    CDigoPostal()
                    ContenedorCodPostal {
                        InputContenedorCodPostal(inputContenedorCodPostaltext = inputContenedorCodPostaltext)
                    }
                    NMeroDeContacto()
                    ContenedorNumContacto {
                        InputContenedorNumContacto(inputContenedorNumContactotext = inputContenedorNumContactotext)
                    }
                    CorreoElectrNico()
                    ContenedorCorreo {
                        InputContenedorCorreo(inputContenedorCorreotext = inputContenedorCorreotext)
                    }
                    DirecciN()
                    CotenedorDireccion {
                        InputCotenedorDireccion(inputCotenedorDirecciontext = inputCotenedorDirecciontext)
                    }
                    BtnSiguiente(onBtnSiguiente = onBtnSiguiente) {
                        Siguiente()
                    }
                    BtnVolverAux(onBtnVolverAux = onBtnVolverAux) {
                        Volver()
                    }
                }
            }
        }
    }
}

@Composable
fun InformaciNDelPredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Información del predio:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun NombreDelPredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Nombre del predio:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(164.0.dp)
    )
}

@Composable
fun InputContenedorNombrePredio(
    inputContenedorNombrePrediotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorNombrePrediotext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorNombrePredio(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun RUC(modifier: Modifier = Modifier) {
    RelayText(
        content = "RUC:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(61.0.dp)
    )
}

@Composable
fun InputContenedorRUC(
    inputContenedorRUCtext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorRUCtext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorRUC(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun TIpo(modifier: Modifier = Modifier) {
    RelayText(
        content = "TIpo:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(66.0.dp)
    )
}

@Composable
fun InputContenedorTipo(
    inputContenedorTipotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorTipotext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorTipo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun CDigoPostal(modifier: Modifier = Modifier) {
    RelayText(
        content = "Código postal:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(136.0.dp)
    )
}

@Composable
fun InputContenedorCodPostal(
    inputContenedorCodPostaltext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorCodPostaltext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorCodPostal(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun NMeroDeContacto(modifier: Modifier = Modifier) {
    RelayText(
        content = "Número de contacto:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(183.0.dp)
    )
}

@Composable
fun InputContenedorNumContacto(
    inputContenedorNumContactotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorNumContactotext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorNumContacto(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun CorreoElectrNico(modifier: Modifier = Modifier) {
    RelayText(
        content = "Correo electrónico:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(164.0.dp)
    )
}

@Composable
fun InputContenedorCorreo(
    inputContenedorCorreotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputContenedorCorreotext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun ContenedorCorreo(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun DirecciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Dirección:",
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(97.0.dp)
    )
}

@Composable
fun InputCotenedorDireccion(
    inputCotenedorDirecciontext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputCotenedorDirecciontext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun CotenedorDireccion(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 89,
            red = 109,
            green = 160,
            blue = 239
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 2.0.dp,
            top = 8.0.dp,
            end = 2.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(307.0.dp)
    )
}

@Composable
fun Siguiente(modifier: Modifier = Modifier) {
    RelayText(
        content = "Siguiente",
        fontSize = 16.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun BtnSiguiente(
    onBtnSiguiente: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 63,
            green = 172,
            blue = 54
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 51.0.dp,
            top = 6.0.dp,
            end = 51.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnSiguiente)
            .requiredWidth(307.0.dp)
    )
}

@Composable
fun Volver(modifier: Modifier = Modifier) {
    RelayText(
        content = "Volver",
        fontSize = 16.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun BtnVolverAux(
    onBtnVolverAux: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 249,
            green = 57,
            blue = 57
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 99.0.dp,
            top = 6.0.dp,
            end = 99.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnVolverAux)
            .requiredWidth(307.0.dp)
    )
}

@Composable
fun SubCardInforPredio(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 236,
            green = 249,
            blue = 255
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 10.0.dp,
            top = 19.0.dp,
            end = 10.0.dp,
            bottom = 19.0.dp
        ),
        itemSpacing = 8.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 109,
            green = 160,
            blue = 239
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 15.0.dp),
        itemSpacing = 6.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}
