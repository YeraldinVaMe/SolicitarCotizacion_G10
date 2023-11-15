package com.example.solicitarcotizacion.ui.Resumen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.cardprincipalv3.poppins
import com.example.solicitarcotizacion.tittlev31.TittleV31
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.tappable

@Composable
fun Resumen(navController: NavController, viewModel: ResumenViewModel){
    val image = painterResource(R.drawable.fondo2)

    val inputSolicitudtext : String = viewModel.getInputSolicitudtext()
    val inputNombreSolicitantetext : String = viewModel.getInputNombreSolicitantetext()
    val inputFechatext : String = viewModel.getInputFechatext()
    val inputNombrePrediotext : String = viewModel.getInputNombrePrediotext()
    val inputAreaPrediotext : String = viewModel.getInputAreaPrediotext()
    val inputNumeroCasastext : String = viewModel.getInputNumeroCasastext()
    val inputAreasComunestext : String = viewModel.getInputAreasComunestext()
    val inputServicioSolicitadotext : String = viewModel.getInputServicioSolicitadotext()

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
            RelayContainer(modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()) {
                TittleV31(onBackv31 = {navController.navigate(Screen.CatalogoServicios.route)})
            }
            RelayContainer {
                CardPrincipalv3(
                    inputSolicitudtext = inputSolicitudtext,
                    inputNombreSolicitantetext = inputNombreSolicitantetext,
                    inputFechatext = inputFechatext,
                    inputNombrePrediotext = inputNombrePrediotext,
                    inputAreaPrediotext = inputAreaPrediotext,
                    inputNumeroCasastext = inputNumeroCasastext,
                    inputAreasComunestext = inputAreasComunestext,
                    inputServicioSolicitadotext = inputServicioSolicitadotext,
                    onBtnEnviarCorreo = {},
                    onBtnMenuPrincipal = {navController.navigate(Screen.CatalogoServicios.route)}
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ResumenView(){
    MaterialTheme {
        Resumen(rememberNavController(), ResumenViewModel())
    }
}

//CARD DE RESUMEN
@Composable
fun CardPrincipalv3(
    modifier: Modifier = Modifier,
    inputSolicitudtext: String = "",
    inputNombreSolicitantetext: String = "",
    inputFechatext: String = "",
    inputNombrePrediotext: String = "",
    inputAreaPrediotext: String = "",
    inputNumeroCasastext: String = "",
    inputAreasComunestext: String = "",
    inputServicioSolicitadotext: String = "",
    onBtnEnviarCorreo: () -> Unit = {},
    onBtnMenuPrincipal: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            item {
                FormatoDeLaSolicitud()
                ContenedorPrincipal {
                    NSolicitud()
                    Solicitud {
                        InputSolicitud(
                            inputSolicitudtext = inputSolicitudtext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 12.0.dp,
                                    y = 9.0.dp
                                )
                            )
                        )
                        SolicitudSynth {}
                    }
                    NombreDelSolicitante()
                    NombreSolicitante {
                        InputNombreSolicitante(
                            inputNombreSolicitantetext = inputNombreSolicitantetext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 9.0.dp,
                                    y = 11.0.dp
                                )
                            )
                        )
                        NombreSolicitanteSynth {}
                    }
                    FechaDeSolicitud()
                    Fecha {
                        InputFecha(
                            inputFechatext = inputFechatext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 8.0.dp,
                                    y = 9.0.dp
                                )
                            )
                        )
                        FechaSynth {}
                    }
                    Predio()
                    NombrePredio {
                        InputNombrePredio(
                            inputNombrePrediotext = inputNombrePrediotext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 9.0.dp,
                                    y = 6.0.dp
                                )
                            )
                        )
                        NombrePredioSynth {}
                    }
                    ReaDelPredio()
                    AreaPredio {
                        InputAreaPredio(
                            inputAreaPrediotext = inputAreaPrediotext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 11.0.dp,
                                    y = 9.0.dp
                                )
                            )
                        )
                        AreaPredioSynth {}
                    }
                    NMeroDeCasasHabitaciN()
                    NumeroCasas {
                        InputNumeroCasas(
                            inputNumeroCasastext = inputNumeroCasastext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 12.0.dp,
                                    y = 9.0.dp
                                )
                            )
                        )
                        NumeroCasasSynth {}
                    }
                    ReasComunes()
                    AreasComunes {
                        InputAreasComunes(
                            inputAreasComunestext = inputAreasComunestext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 7.0.dp,
                                    y = 9.0.dp
                                )
                            )
                        )
                        AreasComunesSynth {}
                    }
                    ServicioSolicitado()
                    ServicioSolicitado {
                        InputServicioSolicitado(
                            inputServicioSolicitadotext = inputServicioSolicitadotext,
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 9.0.dp,
                                    y = 7.0.dp
                                )
                            )
                        )
                        ServicioSolicitadoSynth {}
                    }
                }
            }
            item {
                CardPrincipalvv3 {
                    BtnEnviarCorreo(onBtnEnviarCorreo = onBtnEnviarCorreo) {
                        EnviarAlCorreo()
                    }
                    BtnMenuPrincipal(onBtnMenuPrincipal = onBtnMenuPrincipal) {
                        RegresarAlMenPrincipal()
                    }
                }
            }
        }
    }
}

@Composable
fun FormatoDeLaSolicitud(modifier: Modifier = Modifier) {
    RelayText(
        content = "Formato de la solicitud:",
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
fun NSolicitud(modifier: Modifier = Modifier) {
    RelayText(
        content = "N°  Solicitud:",
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
        modifier = modifier.requiredWidth(106.0.dp)
    )
}

@Composable
fun InputSolicitud(
    inputSolicitudtext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputSolicitudtext,
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
fun SolicitudSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun Solicitud(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun NombreDelSolicitante(modifier: Modifier = Modifier) {
    RelayText(
        content = "Nombre del solicitante:",
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
fun InputNombreSolicitante(
    inputNombreSolicitantetext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputNombreSolicitantetext,
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
fun NombreSolicitanteSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun NombreSolicitante(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun FechaDeSolicitud(modifier: Modifier = Modifier) {
    RelayText(
        content = "Fecha de solicitud:",
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
        modifier = modifier.requiredWidth(154.0.dp)
    )
}

@Composable
fun InputFecha(
    inputFechatext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputFechatext,
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
fun FechaSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun Fecha(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun Predio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Predio:",
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
        modifier = modifier.requiredWidth(69.0.dp)
    )
}

@Composable
fun InputNombrePredio(
    inputNombrePrediotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputNombrePrediotext,
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
fun NombrePredioSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun NombrePredio(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ReaDelPredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Área del predio:",
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
        modifier = modifier.requiredWidth(129.0.dp)
    )
}

@Composable
fun InputAreaPredio(
    inputAreaPrediotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputAreaPrediotext,
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
fun AreaPredioSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun AreaPredio(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun NMeroDeCasasHabitaciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Número de casas - Habitación:",
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
        modifier = modifier.requiredWidth(256.0.dp)
    )
}

@Composable
fun InputNumeroCasas(
    inputNumeroCasastext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputNumeroCasastext,
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
fun NumeroCasasSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun NumeroCasas(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ReasComunes(modifier: Modifier = Modifier) {
    RelayText(
        content = "Áreas comunes:",
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
        modifier = modifier.requiredWidth(132.0.dp)
    )
}

@Composable
fun InputAreasComunes(
    inputAreasComunestext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputAreasComunestext,
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
fun AreasComunesSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .requiredWidth(307.0.dp)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun AreasComunes(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun ServicioSolicitado(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio solicitado:",
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
fun InputServicioSolicitado(
    inputServicioSolicitadotext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputServicioSolicitadotext,
        fontSize = 15.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(300.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(290.0.dp)
    )
}

@Composable
fun ServicioSolicitadoSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(307.0.dp, Dp.Infinity)
            .heightIn(54.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun ServicioSolicitado(
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
        isStructured = false,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ContenedorPrincipal(
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
            start = 15.0.dp,
            top = 10.0.dp,
            end = 15.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 4.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun EnviarAlCorreo(modifier: Modifier = Modifier) {
    RelayText(
        content = "Enviar correo",
        fontSize = 16.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        modifier = modifier
    )
}

@Composable
fun BtnEnviarCorreo(
    onBtnEnviarCorreo: () -> Unit,
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
            start = 20.0.dp,
            top = 4.0.dp,
            end = 20.0.dp,
            bottom = 4.0.dp
        ),
        itemSpacing = 20.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnEnviarCorreo)
            .requiredWidth(158.0.dp)
            .requiredHeight(56.dp)
    )
}

@Composable
fun RegresarAlMenPrincipal(modifier: Modifier = Modifier) {
    RelayText(
        content = "Ir al menú",
        fontSize = 16.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        modifier = modifier
    )
}

@Composable
fun BtnMenuPrincipal(
    onBtnMenuPrincipal: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 19,
            green = 99,
            blue = 223
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 20.0.dp,
            top = 1.0.dp,
            end = 20.0.dp,
            bottom = 1.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnMenuPrincipal)
            .requiredWidth(167.0.dp)
            .requiredHeight(56.dp)
    )
}

@Composable
fun CardPrincipalvv3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
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
        padding = PaddingValues(
            start = 15.0.dp,
            top = 13.0.dp,
            end = 15.0.dp,
            bottom = 13.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}