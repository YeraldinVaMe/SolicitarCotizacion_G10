package com.example.solicitarcotizacion.ui.CatalogoServicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.boxadmgeneral.BoxAdmGeneral
import com.example.solicitarcotizacion.boxservespecificos.poppins
import com.example.solicitarcotizacion.descrip.Descrip
import com.example.solicitarcotizacion.titlecs.TitleCs
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

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
                    modifier = Modifier
                        .rowWeight(1.0f)
                        .columnWeight(1.0f),
                    navController = navController
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

//BOX SERVICIOS ESPECÍFICOS
@Composable
fun BoxServEspecificos(
    modifier: Modifier = Modifier,
    onbtnSolicitar: () -> Unit = {},
    navController: NavController
) {
    val oncheckBoxGuardias = remember { mutableStateOf(false)}
    val oncheckBoxLimpieza = remember { mutableStateOf(false)}
    val oncheckBoxJardineria = remember { mutableStateOf(false)}
    val oncheckBoxAreas = remember { mutableStateOf(false)}

    oncheckBoxLimpieza
    TopLevel(modifier = modifier) {
        TopLevelSynth {
            Fondo()
        }
        SSeguridad(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f)) {
            Rectan1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )

            Checkbox(
                checked = oncheckBoxGuardias.value,
                onCheckedChange = {oncheckBoxGuardias.value = it},
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 54.0.dp,
                        y = -8.dp
                    )
                )
            )

            Image3(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 41.5.dp,
                        y = 84.4976806640625.dp
                    )
                )
            )

            GuardiasDeSeguridad247(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = 36.21331787109375.dp
                    )
                )
            )
        }
        SLimpieza(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f)) {
            Rectan2(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            Checkbox(
                checked = oncheckBoxLimpieza.value,
                onCheckedChange = {oncheckBoxLimpieza.value = it},
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 54.0.dp,
                        y = -8.dp
                    )
                )
            )

            ServicioDeLimpieza(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = 36.21331787109375.dp
                    )
                )
            )
            Image4(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 37.5.dp,
                        y = 80.4739990234375.dp
                    )
                )
            )
        }
        SJardineria(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f)) {
            Rectan3(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )

            Checkbox(
                checked = oncheckBoxJardineria.value,
                onCheckedChange = {oncheckBoxJardineria.value = it},
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 54.0.dp,
                        y = -8.dp
                    )
                )
            )

            ServicioDeJardinerA(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = 36.213287353515625.dp
                    )
                )
            )
            Image5(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 39.5.dp,
                        y = 80.4739990234375.dp
                    )
                )
            )
        }
        SAreaComun(modifier = Modifier
            .rowWeight(1.0f)
            .columnWeight(1.0f)) {
            Rectan4(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            Checkbox(
                checked = oncheckBoxAreas.value,
                onCheckedChange = {oncheckBoxAreas.value = it},
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 54.0.dp,
                        y = -8.dp
                    )
                )
            )
            ReasComunes(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = 46.272552490234375.dp
                    )
                )
            )
            Image6(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 38.0.dp,
                        y = 79.0.dp
                    )
                )
            )
        }
        BtnSolicitar(
            onbtnSolicitar = { navController.navigate(Screen.solicitarCotizacion.route) },
            modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f)
        ) {
            Rectangle2(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            SolicitarCotizaciN(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.5.dp,
                        y = 6.0.dp
                    )
                )
            )
        }
    }
}

@Composable
fun Fondo(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_fondo),
        modifier = modifier
            .requiredWidth(355.0.dp)
            .requiredHeight(428.0.dp)
    )
}

@Composable
fun TopLevelSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.alpha(alpha = 100.0f)
    )
}

@Composable
fun Rectan1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_rectan1),
        modifier = modifier
            .requiredWidth(140.0.dp)
            .requiredHeight(138.0.dp)
    )
}

@Composable
fun CheckBoxGuardias(
    oncheckBoxGuardias: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_check_box_guardias),
        modifier = modifier
            .tappable(onTap = oncheckBoxGuardias)
            .requiredWidth(20.0.dp)
            .requiredHeight(20.1185302734375.dp)
    )
}

@Composable
fun Image3(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.box_serv_especificos_image_3),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(43.0.dp)
            .requiredHeight(41.242919921875.dp)
    )
}

@Composable
fun GuardiasDeSeguridad247(modifier: Modifier = Modifier) {
    RelayText(
        content = "Guardias de seguridad 24/7",
        fontSize = 13.0.sp,
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
            .requiredWidth(119.0.dp)
            .requiredHeight(29.17181396484375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun SSeguridad(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 28.0.dp,
                    top = 25.0.dp,
                    end = 187.0.dp,
                    bottom = 265.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectan2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_rectan2),
        modifier = modifier
            .requiredWidth(140.0.dp)
            .requiredHeight(138.0.dp)
    )
}

@Composable
fun CheckBoxLimpieza(
    oncheckBoxLimpieza: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_check_box_limpieza),
        modifier = modifier
            .tappable(onTap = oncheckBoxLimpieza)
            .requiredWidth(20.0.dp)
            .requiredHeight(20.1185302734375.dp)
    )
}

@Composable
fun ServicioDeLimpieza(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio de limpieza",
        fontSize = 13.0.sp,
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
            .requiredWidth(119.0.dp)
            .requiredHeight(29.17181396484375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Image4(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.box_serv_especificos_image_4),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(45.0.dp)
            .requiredHeight(45.266632080078125.dp)
    )
}

@Composable
fun SLimpieza(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 186.0.dp,
                    top = 25.0.dp,
                    end = 29.0.dp,
                    bottom = 265.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectan3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_rectan3),
        modifier = modifier
            .requiredWidth(140.0.dp)
            .requiredHeight(138.0.dp)
    )
}

@Composable
fun CheckBoxJardineria(
    oncheckBoxJardineria: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_check_box_jardineria),
        modifier = modifier
            .tappable(onTap = oncheckBoxJardineria)
            .requiredWidth(20.0.dp)
            .requiredHeight(20.118499755859375.dp)
    )
}

@Composable
fun ServicioDeJardinerA(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio de jardinería",
        fontSize = 13.0.sp,
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
            .requiredWidth(119.0.dp)
            .requiredHeight(29.17181396484375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Image5(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.box_serv_especificos_image_5),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(45.0.dp)
            .requiredHeight(45.266632080078125.dp)
    )
}

@Composable
fun SJardineria(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 28.0.dp,
                    top = 181.0.dp,
                    end = 187.0.dp,
                    bottom = 109.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectan4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_rectan4),
        modifier = modifier
            .requiredWidth(140.0.dp)
            .requiredHeight(138.0.dp)
    )
}

@Composable
fun CheckBoxAreas(
    oncheckBoxAreas: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_check_box_areas),
        modifier = modifier
            .tappable(onTap = oncheckBoxAreas)
            .requiredWidth(20.0.dp)
            .requiredHeight(20.118499755859375.dp)
    )
}

@Composable
fun ReasComunes(modifier: Modifier = Modifier) {
    RelayText(
        content = "Áreas comunes",
        fontSize = 13.0.sp,
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
            .requiredWidth(119.0.dp)
            .requiredHeight(9.053314208984375.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Image6(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.box_serv_especificos_image_6),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(50.0.dp)
            .requiredHeight(50.0.dp)
    )
}

@Composable
fun SAreaComun(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 186.0.dp,
                    top = 181.0.dp,
                    end = 29.0.dp,
                    bottom = 109.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.box_serv_especificos_rectangle_2),
        modifier = modifier
            .requiredWidth(200.0.dp)
            .requiredHeight(36.0.dp)
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
        maxLines = -1,
        modifier = modifier
            .requiredWidth(167.0.dp)
            .requiredHeight(25.0.dp)
    )
}

@Composable
fun BtnSolicitar(
    onbtnSolicitar: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 30.0,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 78.0.dp,
                    top = 358.0.dp,
                    end = 77.0.dp,
                    bottom = 34.0.dp
                )
            )
            .tappable(onTap = onbtnSolicitar)
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}