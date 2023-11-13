package com.example.solicitarcotizacion.ui.solicitarCotizacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.solicitarcotizacion.cardprincipalv1.poppins
import com.example.solicitarcotizacion.gruponombrev1.GrupoNombrev1
import com.example.solicitarcotizacion.textsubv1.TextSubv1
import com.example.solicitarcotizacion.titulo12principal.Titulo12principal
import com.example.solicitarcotizacion.tituloprincv1.TituloPrincv1
import com.example.solicitarcotizacion.ui.theme.SolicitarCotizacionTheme
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

@Composable
fun SolicitarCotizacion(navController: NavController){
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
                .padding(start = 15.dp, end = 15.dp, bottom = 38.dp, top = 38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Titulo12principal(
                    onBack13 = {navController.navigate(Screen.CatalogoServicios.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }
            RelayContainer(
                Modifier
                    .height(60.dp)
                    .padding(bottom = 14.dp)
            ) {
                TextSubv1(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
            RelayContainer(
                Modifier
                    .height(75.dp)
                    .padding(bottom = 14.dp)
            ) {
                GrupoNombrev1(
                    inputNombre = "Adrian Ernesto Zavaleta Vega",
                    modifier = Modifier
                        .rowWeight(1.0f)
                        .columnWeight(1.0f)
                )
            }
            RelayContainer(
                Modifier.fillMaxHeight()
            ) {
                CardPrincipalv1(
                    onBtnVolverSeleccionarv1 = {navController.navigate(Screen.CatalogoServicios.route)},
                    onBtnBuscarPredio = {navController.navigate(Screen.VerPredio.route)},
                    onBtnRegistrarPredio = {navController.navigate(Screen.AgregarPredio.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SolicitarCotizacionPreview(){
    SolicitarCotizacionTheme {
        SolicitarCotizacion(rememberNavController())
    }
}

//CARD PRINCIPAL
@Composable
fun CardPrincipalv1(
    modifier: Modifier = Modifier,
    onBtnVolverSeleccionarv1: () -> Unit = {},
    onBtnBuscarPredio: () -> Unit = {},
    onBtnRegistrarPredio: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp))
        {
            item {
                MsnBienvenida(modifier = Modifier.padding(bottom = 10.dp))
                CardInfoServicios(modifier = Modifier.fillMaxWidth()) {
                    AdmGeneralv1 {
                        AdministraciNGeneral()
                        numAdministracionGeneral(readonly = true)
                    }
                    GuardiasSegv1 {
                        GuardiasDeSeguridad()
                        numSeguridad(readonly = false)
                    }
                    ServLimpiezav1 {
                        ServicioDeLimpieza()
                        numLimpieza(readonly = false)
                    }
                    ServJardineriav1 {
                        ServicioDeJardinerA()
                        numJardineria(readonly = false)
                    }
                    BtnVolverSeleccionarv1(onBtnVolverSeleccionarv1 = onBtnVolverSeleccionarv1) {
                        VolverASeleccionar()
                    }
                }
            }
            item {
                IngreseLosSiguientesDatos(modifier = Modifier.padding(bottom = 10.dp))
                CardPrincipalPredio(modifier = Modifier.fillMaxWidth()) {
                    Predio()
                    inputPredio()
                    BtnBuscarPredio(onBtnBuscarPredio = onBtnBuscarPredio) {
                        Vector()
                        Buscar()
                    }
                    PreguntaPorPredio()
                    BtnRegistrarPredio(onBtnRegistrarPredio = onBtnRegistrarPredio) {
                        IniciarRegistroDePredio()
                    }
                }
            }
        }
    }
}

@Composable
fun MsnBienvenida(modifier: Modifier = Modifier) {
    RelayText(
        content = "¡ Felicidades usted contará con el servicio de  “Administración general” !",
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
        modifier = modifier.requiredWidth(319.0.dp)
    )
}

@Composable
fun AdministraciNGeneral(modifier: Modifier = Modifier) {
    RelayText(
        content = "Administración general:",
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
fun Rectangle48(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_rectangle_48),
        modifier = modifier
            .requiredWidth(83.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun AdmGeneralv1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 20.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(288.0.dp)
    )
}

@Composable
fun GuardiasDeSeguridad(modifier: Modifier = Modifier) {
    RelayText(
        content = "Guardias de seguridad:",
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
fun Rectangle78(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_rectangle_78),
        modifier = modifier
            .requiredWidth(84.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun GuardiasSegv1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 23.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ServicioDeLimpieza(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio de limpieza:",
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
fun Rectangle79(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_rectangle_79),
        modifier = modifier
            .requiredWidth(84.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun ServLimpiezav1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 44.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun ServicioDeJardinerA(modifier: Modifier = Modifier) {
    RelayText(
        content = "Servicio de Jardinería:",
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
fun Rectangle80(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_rectangle_80),
        modifier = modifier
            .requiredWidth(85.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun ServJardineriav1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 36.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun VolverASeleccionar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Volver a seleccionar",
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
fun BtnVolverSeleccionarv1(
    onBtnVolverSeleccionarv1: () -> Unit,
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
            start = 16.0.dp,
            top = 6.0.dp,
            end = 16.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnVolverSeleccionarv1)
            .requiredWidth(251.0.dp)
    )
}

@Composable
fun CardInfoServicios(
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
            start = 15.0.dp,
            top = 11.0.dp,
            end = 15.0.dp,
            bottom = 11.0.dp
        ),
        itemSpacing = 9.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun IngreseLosSiguientesDatos(modifier: Modifier = Modifier) {
    RelayText(
        content = "Ingrese los siguientes datos",
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
        modifier = modifier.requiredWidth(68.0.dp)
    )
}

@Composable
fun ContenedorEscribirPredio(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_contenedor_escribir_predio),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_principalv1_vector),
        modifier = modifier
            .requiredWidth(18.66668701171875.dp)
            .requiredHeight(22.360992431640625.dp)
    )
}

@Composable
fun Buscar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Buscar",
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
        maxLines = -1,
        modifier = modifier
    )
}

@Composable
fun BtnBuscarPredio(
    onBtnBuscarPredio: () -> Unit,
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
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 12.0.dp,
            top = 5.0.dp,
            end = 12.0.dp,
            bottom = 5.0.dp
        ),
        itemSpacing = 4.0,
        radius = 30.0,
        content = content,
        modifier = modifier.tappable(onTap = onBtnBuscarPredio)
    )
}

@Composable
fun PreguntaPorPredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "¿Tu predio no está registrado?",
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
        modifier = modifier.requiredWidth(265.0.dp)
    )
}

@Composable
fun IniciarRegistroDePredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Iniciar registro de predio",
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
fun BtnRegistrarPredio(
    onBtnRegistrarPredio: () -> Unit,
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
            start = 19.0.dp,
            top = 6.0.dp,
            end = 19.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier.tappable(onTap = onBtnRegistrarPredio)
    )
}

@Composable
fun CardPrincipalPredio(
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
            start = 8.0.dp,
            top = 12.0.dp,
            end = 8.0.dp,
            bottom = 12.0.dp
        ),
        itemSpacing = 5.0,
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
        padding = PaddingValues(
            start = 17.0.dp,
            top = 20.0.dp,
            end = 17.0.dp,
            bottom = 20.0.dp
        ),
        itemSpacing = 11.0,
        radius = 10.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

//FIELDS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numAdministracionGeneral (modifier: Modifier = Modifier, readonly: Boolean){

    var num by remember { mutableStateOf("1") }

    TextField(
        value = num,
        onValueChange = { num = it },
        textStyle = TextStyle(
            fontSize = 12.0.sp,
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
            .width(84.dp)
            .fillMaxWidth(),
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        readOnly = readonly,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numSeguridad (modifier: Modifier = Modifier, readonly: Boolean){

    var num by remember { mutableStateOf("0") }

    TextField(
        value = num,
        onValueChange = { num = it },
        textStyle = TextStyle(
            fontSize = 12.0.sp,
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
            .width(84.dp)
            .fillMaxWidth(),
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        readOnly = readonly,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numLimpieza (modifier: Modifier = Modifier, readonly: Boolean){

    var num by remember { mutableStateOf("0") }

    TextField(
        value = num,
        onValueChange = { num = it },
        textStyle = TextStyle(
            fontSize = 12.0.sp,
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
            .width(84.dp)
            .fillMaxWidth(),
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        readOnly = readonly,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numJardineria (modifier: Modifier = Modifier, readonly: Boolean){

    var num by remember { mutableStateOf("0") }

    TextField(
        value = num,
        onValueChange = { num = it },
        textStyle = TextStyle(
            fontSize = 12.0.sp,
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
            .width(84.dp)
            .fillMaxWidth(),
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        readOnly = readonly,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputPredio(){
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Las Gaviotas", "Los Koalas", "Los Tulipanes", "Los Sauces")
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    TextField(
        value = selectedText,
        onValueChange = { selectedText = it },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                textfieldSize = coordinates.size.toSize()
            },
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        placeholder = {
            Text(text = "Seleccione su predio")
        },
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