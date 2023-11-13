package com.example.solicitarcotizacion.ui.VerAreasComunes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import com.example.solicitarcotizacion.cardagregarpredioaux.poppins
import com.example.solicitarcotizacion.titulo12principal.Titulo12principal
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

@Composable
fun VerAreasComunes(navController: NavController){
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
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer(
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Titulo12principal(
                    onBack13 = {navController.navigate(Screen.VerPredio.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }

            RelayContainer {
                CardAgregarPredioAux(
                    inputTipoAreaAuxxtext = "Parque interno",
                    inputAreaAuxxtext = "888",
                    inputCantidadAreatext = "2",
                    modifier = Modifier.columnWeight(1.0f),
                    onBtnSolicitarCotizacionAux = {navController.navigate(Screen.Resumen.route)},
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun VerAreasComunesView(){
    MaterialTheme {
        VerAreasComunes(rememberNavController())
    }
}

//CARD AREAS COMUNES
@Composable
fun CardAgregarPredioAux(
    modifier: Modifier = Modifier,
    inputTipoAreaAuxxtext: String = "",
    inputAreaAuxxtext: String = "",
    inputCantidadAreatext: String = "",
    onBtnSolicitarCotizacionAux: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp))
        {
            item {
                PropiedadAux()
                CardAreaPropiedadAux {
                    ReaPredioM()
                    ContenidoAreapredio()
                    NMeroDeCasasHabitaciN()
                    ContenidoNumCasas()
                }
            }
            item {
                ServicioAux()
                CardAgregarAreasComunesAux {
                    ReasComunes()
                    BotonesAux {
                        BtnAgregarAreaComunAux {
                            Agregar()
                        }
                        BtnEliminarAreaAux(
                            modifier = Modifier.boxAlign(
                                alignment = Alignment.TopStart,
                                offset = DpOffset(
                                    x = 158.0.dp,
                                    y = 0.0.dp
                                )
                            )
                        ) {
                            Eliminar()
                        }
                    }
                    CardTipoAreaAux {
                        Frame46 {
                            TipoDeReaComN()
                            ReaM()
                        }
                        FrameTipoArea {
                            ConteTipoareaAux {
                                InputTipoAreaAuxx(
                                    inputTipoAreaAuxxtext = inputTipoAreaAuxxtext,
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.TopStart,
                                        offset = DpOffset(
                                            x = 10.0.dp,
                                            y = 7.0.dp
                                        )
                                    )
                                )
                                ConteTipoareaAuxSynth {}
                            }
                            AreaAuxx {
                                InputAreaAuxx(
                                    inputAreaAuxxtext = inputAreaAuxxtext,
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.TopStart,
                                        offset = DpOffset(
                                            x = 7.0.dp,
                                            y = 8.0.dp
                                        )
                                    )
                                )
                                AreaAuxxSynth {}
                            }
                        }
                    }
                    CantidadDeReasComunes()
                    Frame70 {
                        InputCantidadArea(inputCantidadAreatext = inputCantidadAreatext)
                    }
                }
            }
            item {
                BtnSolicitarCotizacionAux(onBtnSolicitarCotizacionAux = onBtnSolicitarCotizacionAux) {
                    SolicitarCotizaciN()
                }
            }
        }
    }
}

@Composable
fun PropiedadAux(modifier: Modifier = Modifier) {
    RelayText(
        content = "Propiedad:",
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
        modifier = modifier.requiredWidth(100.0.dp)
    )
}

@Composable
fun ReaPredioM(modifier: Modifier = Modifier) {
    RelayText(
        content = "Área predio (m²)",
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
        modifier = modifier.requiredWidth(140.0.dp)
    )
}

@Composable
fun ContenidoAreapredio(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_agregar_predio_aux_contenido_areapredio),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
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
        modifier = modifier
    )
}

@Composable
fun ContenidoNumCasas(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_agregar_predio_aux_contenido_num_casas),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun CardAreaPropiedadAux(
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
            start = 8.0.dp,
            top = 21.0.dp,
            end = 8.0.dp,
            bottom = 21.0.dp
        ),
        itemSpacing = 7.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ServicioAux(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio:",
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
        modifier = modifier.requiredWidth(74.0.dp)
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
        modifier = modifier.requiredWidth(134.0.dp)
    )
}

@Composable
fun Agregar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Agregar",
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
fun BtnAgregarAreaComunAux(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 88,
            green = 94,
            blue = 102
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 17.0.dp,
            top = 6.0.dp,
            end = 17.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 20.0,
        radius = 30.0,
        content = content,
        modifier = modifier.requiredWidth(151.0.dp)
    )
}

@Composable
fun Eliminar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Eliminar",
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
fun BtnEliminarAreaAux(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 88,
            green = 94,
            blue = 102
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 20.0.dp,
            top = 6.0.dp,
            end = 20.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier.requiredWidth(146.0.dp)
    )
}

@Composable
fun BotonesAux(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 30.0,
        content = content,
        modifier = modifier
            .requiredWidth(304.0.dp)
            .requiredHeight(36.0.dp)
    )
}

@Composable
fun TipoDeReaComN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Tipo de área común",
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
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun ReaM(modifier: Modifier = Modifier) {
    RelayText(
        content = "Área (m²)",
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
        maxLines = -1,
        modifier = modifier.requiredWidth(78.0.dp)
    )
}

@Composable
fun Frame46(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 26.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun InputTipoAreaAuxx(
    inputTipoAreaAuxxtext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputTipoAreaAuxxtext,
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
        maxLines = -1,
        modifier = modifier.requiredWidth(123.0.dp)
    )
}

@Composable
fun ConteTipoareaAuxSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(164.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun ConteTipoareaAux(
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
fun InputAreaAuxx(
    inputAreaAuxxtext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputAreaAuxxtext,
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
        maxLines = -1,
        modifier = modifier.requiredWidth(40.0.dp)
    )
}

@Composable
fun AreaAuxxSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
            .widthIn(108.0.dp, Dp.Infinity)
            .heightIn(39.0.dp, Dp.Infinity)
            .alpha(alpha = 100.0f)
    )
}

@Composable
fun AreaAuxx(
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
fun FrameTipoArea(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 18.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun CardTipoAreaAux(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 2.0,
        radius = 10.0,
        strokeWidth = 1.0,
        strokeColor = Color(
            alpha = 127,
            red = 88,
            green = 94,
            blue = 102
        ),
        content = content,
        modifier = modifier
    )
}

@Composable
fun CantidadDeReasComunes(modifier: Modifier = Modifier) {
    RelayText(
        content = "Cantidad de áreas comunes:",
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
        maxLines = -1,
        modifier = modifier.requiredWidth(248.0.dp)
    )
}

@Composable
fun InputCantidadArea(
    inputCantidadAreatext: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputCantidadAreatext,
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
fun Frame70(
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
            start = 30.0.dp,
            top = 8.0.dp,
            end = 30.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 10.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun CardAgregarAreasComunesAux(
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
        padding = PaddingValues(
            start = 5.0.dp,
            top = 10.0.dp,
            end = 5.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 30.0,
        radius = 10.0,
        content = content,
        modifier = modifier.requiredWidth(325.0.dp)
    )
}

@Composable
fun SolicitarCotizaciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Solicitar cotización",
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
fun BtnSolicitarCotizacionAux(
    onBtnSolicitarCotizacionAux: () -> Unit,
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
            top = 10.0.dp,
            end = 20.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnSolicitarCotizacionAux)
            .requiredWidth(323.0.dp)
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
            start = 13.0.dp,
            top = 17.0.dp,
            end = 13.0.dp,
            bottom = 18.0.dp
        ),
        itemSpacing = 17.0,
        radius = 10.0,
        content = content,
        modifier = modifier.fillMaxHeight(1.0f)
    )
}
