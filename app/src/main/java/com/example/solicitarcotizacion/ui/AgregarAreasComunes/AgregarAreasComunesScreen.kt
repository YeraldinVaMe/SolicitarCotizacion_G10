package com.example.solicitarcotizacion.ui.AgregarAreasComunes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.cardagregarpredio12.poppins
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
fun AgregarAreasComunes(navController: NavController){
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
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Titulo12principal(
                    onBack13 = {navController.navigate(Screen.AgregarPredio.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }
            RelayContainer(
                modifier = Modifier.fillMaxHeight()
            ) {
                CardAgregarPredio12(navController = navController)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AgregarAreasComunesView(){
    MaterialTheme {
        AgregarAreasComunes(rememberNavController())
    }
}

//CARD AGREGAR ÁREAS COMUNES
@Composable
fun CardAgregarPredio12(
    modifier: Modifier = Modifier,
    inputCantAreas: String = "",
    onBtnSolicitarCotizacion: () -> Unit = {},
    onBtnAgregarAreaComun: () -> Unit = {},
    onBtnEliminarArea: () -> Unit = {},
    navController: NavController
) {
    TopLevel(modifier = modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            item {
                Propiedad()
                CardAreaPropiedad(
                    Modifier.fillMaxWidth()
                ) {
                    ReaPredioM()
                    areaPredioField()
                    NMeroDeCasasHabitaciN()
                    nroCasasField()
                }
            }
            item {
                Servicio()
                CardAgregarAreasComunes(
                    Modifier.fillMaxWidth()
                ) {
                    ReasComunes()
                    Botones {
                        BtnAgregarAreaComun(onBtnAgregarAreaComun = onBtnAgregarAreaComun) {
                            Agregar()
                        }
                        BtnEliminarArea(
                            onBtnEliminarArea = onBtnEliminarArea,
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
                    CardAuxTipoArea {
                        Frame46 {
                            TipoDeReaComN()
                            ReaM()
                        }
                        Frame47 {
                            tipoAreaComun()
                            areaAreaComun()
                        }
                    }
                    CantidadDeReasComunes()
                    Frame70 {
                        Class2(inputCantAreas = inputCantAreas)
                    }
                }
            }
            item {
                BtnSolicitarCotizacion(
                    onBtnSolicitarCotizacion = {navController.navigate(Screen.Resumen.route)},
                    modifier = Modifier.fillMaxWidth()) {
                    SolicitarCotizaciN()
                }
            }
        }
    }
}

@Composable
fun Propiedad(modifier: Modifier = Modifier) {
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
fun Rectangle74(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_agregar_predio1_2_rectangle_74),
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
        maxLines = -1
    )
}

@Composable
fun CardAreaPropiedad(
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
fun Servicio(modifier: Modifier = Modifier) {
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
fun BtnAgregarAreaComun(
    onBtnAgregarAreaComun: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 191,
            red = 64,
            green = 172,
            blue = 55
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
        modifier = modifier
            .tappable(onTap = onBtnAgregarAreaComun)
            .requiredWidth(151.0.dp)
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
fun BtnEliminarArea(
    onBtnEliminarArea: () -> Unit,
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
            top = 6.0.dp,
            end = 20.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnEliminarArea)
            .requiredWidth(146.0.dp)
    )
}

@Composable
fun Botones(
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
        modifier = modifier.requiredWidth(161.0.dp)
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
fun Rectangle58(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_agregar_predio1_2_rectangle_58),
        modifier = modifier
            .requiredWidth(164.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun Rectangle68(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_agregar_predio1_2_rectangle_68),
        modifier = modifier
            .requiredWidth(108.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun Frame47(
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
fun CardAuxTipoArea(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 18.0.dp,
            top = 10.0.dp,
            end = 18.0.dp,
            bottom = 10.0.dp
        ),
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
fun Class2(
    inputCantAreas: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = inputCantAreas,
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
fun CardAgregarAreasComunes(
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
        modifier = modifier
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
fun BtnSolicitarCotizacion(
    onBtnSolicitarCotizacion: () -> Unit,
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
            .tappable(onTap = onBtnSolicitarCotizacion)
            .requiredWidth(325.0.dp)
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
            top = 18.0.dp,
            end = 13.0.dp,
            bottom = 18.0.dp
        ),
        itemSpacing = 17.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

//FIELDS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun areaPredioField (modifier: Modifier = Modifier){

    var areaPredio by remember { mutableStateOf("") }

    TextField(
        value = areaPredio,
        onValueChange = { areaPredio = it },
        textStyle = TextStyle(
            fontSize = 14.0.sp,
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            textAlign = TextAlign.Left
        ),
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = modifier
            .fillMaxWidth(),
        placeholder = {
            Text(text = "Ingrese el área del predio")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nroCasasField (modifier: Modifier = Modifier){

    var nroCasas by remember { mutableStateOf("") }

    TextField(
        value = nroCasas,
        onValueChange = { nroCasas = it },
        textStyle = TextStyle(
            fontSize = 14.0.sp,
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            textAlign = TextAlign.Left
        ),
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = modifier
            .fillMaxWidth(),
        placeholder = {
            Text(text = "Ingrese el número de casas")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tipoAreaComun(){
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Parque", "Salón", "Estacionamiento")
    var selectedText by remember { mutableStateOf("")}
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    TextField(
        value = selectedText,
        onValueChange = { selectedText = it },
        modifier = Modifier
            .requiredWidth(164.dp)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        trailingIcon = {
            Icon(icon,"contentDescription",
                Modifier.clickable { expanded = !expanded })
        }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
    ) {
        items.forEach { label ->
            DropdownMenuItem(onClick = {
                selectedText = label
                expanded = false
            }) {
                Text(text = label)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun areaAreaComun (modifier: Modifier = Modifier){

    var areaComun by remember { mutableStateOf("") }

    TextField(
        value = areaComun,
        onValueChange = { areaComun = it },
        textStyle = TextStyle(
            fontSize = 14.0.sp,
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            textAlign = TextAlign.Left
        ),
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = modifier
            .requiredWidth(108.dp),
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}