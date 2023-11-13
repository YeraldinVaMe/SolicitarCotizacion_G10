package com.example.solicitarcotizacion.ui.AgregarPredio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.solicitarcotizacion.cardregistropredio.poppins
import com.example.solicitarcotizacion.titulo12principal.Titulo12principal
import com.example.solicitarcotizacion.tituloprincv1.TituloPrincv1
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

@Composable
fun AgregarPredioS(navController: NavController){
    val image = painterResource(R.drawable.fondo2)

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
                .padding(start = 15.dp, end = 15.dp, bottom = 38.dp, top = 38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            RelayContainer(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Titulo12principal(
                    onBack13 = {navController.navigate(Screen.solicitarCotizacion.route)},
                    modifier = Modifier.rowWeight(1.0f)
                )
            }

            RelayContainer(
                Modifier
                    .padding(top = 14.dp)
                    .fillMaxHeight()
            ) {
                CardRegistroPredio(
                    onBtnAgregarPredio = {navController.navigate(Screen.AgregarAreasComunes.route)},
                    onBtnVolver = {navController.navigate(Screen.solicitarCotizacion.route)}
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AgregarPredioView(){
    MaterialTheme {
        AgregarPredioS(rememberNavController())
    }
}

//CARD EDITAR PREDIO
@Composable
fun CardRegistroPredio(
    modifier: Modifier = Modifier,
    onBtnAgregarPredio: () -> Unit = {},
    onBtnVolver: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        InformaciNDelPredio()
        CardSolicitar001 {
            LazyColumn(contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)){
                item {
                    NombreDelPredio()
                    nombresField()
                }
                item {
                    RUC()
                    numRUC()
                }
                item {
                    Tipo()
                    tipoPred()
                }
                item {
                    CDigoPostal()
                    codigoPostal()
                }
                item {
                    NMeroDeContacto()
                    numContacto()
                }
                item {
                    CorreoElectrNico()
                    correoField()
                }
                item {
                    DirecciN()
                    direccionField()
                }
                item {
                    Spacer(modifier = Modifier.padding(top = 15.dp))
                    BtnAgregarPredio(onBtnAgregarPredio = onBtnAgregarPredio) {
                        Group45 {
                            AgregarPredio(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = 51.0.dp,
                                        y = 1.0.dp
                                    )
                                )
                            )
                            Group44 {
                                IcoAdd(
                                    modifier = Modifier.boxAlign(
                                        alignment = Alignment.TopStart,
                                        offset = DpOffset(
                                            x = 26.0.dp,
                                            y = 10.0.dp
                                        )
                                    )
                                ) {
                                    Vector(modifier = Modifier
                                        .rowWeight(1.0f)
                                        .columnWeight(1.0f))
                                }
                                IconEdifi {
                                    Vector1(modifier = Modifier
                                        .rowWeight(1.0f)
                                        .columnWeight(1.0f))
                                }
                            }
                        }
                    }
                }
                item {
                    BtnVolver(onBtnVolver = onBtnVolver) {
                        Volver()
                    }
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nombresField (modifier: Modifier = Modifier){

    var nombres by remember { mutableStateOf("") }

    TextField(
        value = nombres,
        onValueChange = { nombres = it },
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
            Text(text = "Ingrese el nombre")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numRUC (modifier: Modifier = Modifier){

    var numRUC by remember { mutableStateOf("") }

    TextField(
        value = numRUC,
        onValueChange = { numRUC = it },
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
            Text(text = "Ingrese el RUC")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tipoPred(){
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Condominio", "Quinta", "Predio")
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
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        placeholder = {
            Text(text = "Seleccione el tipo de predio")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun codigoPostal(){
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("10001 - Chorrillos", "10002 - Santa Anita", "1003 - Puente Piedra", "10004 - Carabayllo")
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
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
        placeholder = {
            Text(text = "Seleccione su código postal")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numContacto (modifier: Modifier = Modifier){

    var numContacto by remember { mutableStateOf("") }

    TextField(
        value = numContacto,
        onValueChange = { numContacto = it },
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
            Text(text = "Ingrese un número de contacto")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun correoField (modifier: Modifier = Modifier){

    var correo by remember { mutableStateOf("") }

    TextField(
        value = correo,
        onValueChange = { correo = it },
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
            Text(text = "Ingrese su correo")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun direccionField (modifier: Modifier = Modifier){

    var direccion by remember { mutableStateOf("") }

    TextField(
        value = direccion,
        onValueChange = { direccion = it },
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
            Text(text = "Ingrese sus nombres")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
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
fun Rectangle49(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_registro_predio_rectangle_49),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
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
fun Rectangle50(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_registro_predio_rectangle_50),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
    )
}

@Composable
fun Tipo(modifier: Modifier = Modifier) {
    RelayText(
        content = "Tipo:",
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
fun RecTipo(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_registro_predio_rec_tipo),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(39.0.dp)
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
fun AgregarPredio(modifier: Modifier = Modifier) {
    RelayText(
        content = "Agregar predio",
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
        modifier = modifier.requiredWidth(130.0.dp)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_registro_predio_vector),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun IcoAdd(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .requiredWidth(14.0.dp)
            .requiredHeight(13.0.dp)
    )
}

@Composable
fun Vector1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_registro_predio_vector1),
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 3.0.dp,
                    top = 0.0.dp,
                    end = 4.0.dp,
                    bottom = 3.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun IconEdifi(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier
            .requiredWidth(26.0.dp)
            .requiredHeight(26.0.dp)
    )
}

@Composable
fun Group44(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(40.0.dp)
            .requiredHeight(26.0.dp)
    )
}

@Composable
fun Group45(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(181.0.dp)
            .requiredHeight(26.0.dp)
    )
}

@Composable
fun BtnAgregarPredio(
    onBtnAgregarPredio: () -> Unit,
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
        padding = PaddingValues(
            start = 30.0.dp,
            top = 5.0.dp,
            end = 30.0.dp,
            bottom = 5.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnAgregarPredio)
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
fun BtnVolver(
    onBtnVolver: () -> Unit,
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
            start = 86.0.dp,
            top = 6.0.dp,
            end = 86.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        radius = 30.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnVolver)
            .requiredWidth(307.0.dp)
    )
}

@Composable
fun CardSolicitar001(
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
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 15.0.dp),
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
        itemSpacing = 7.0,
        radius = 10.0,
        content = content,
        modifier = modifier
    )
}
