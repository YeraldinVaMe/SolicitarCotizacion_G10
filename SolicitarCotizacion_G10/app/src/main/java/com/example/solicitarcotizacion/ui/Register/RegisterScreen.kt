package com.example.solicitarcotizacion.ui.Register

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.btnconf.BtnConf
import com.example.solicitarcotizacion.cardauxrc.poppins
import com.example.solicitarcotizacion.descrip2.Descrip2
import com.example.solicitarcotizacion.master.MasterViewModel
import com.example.solicitarcotizacion.titleprc.TitlepRc
import com.example.solicitarcotizacion.ui.theme.SolicitarCotizacionTheme
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

@Composable
fun Register(navController: NavController,viewModel: RegisterViewModel, masterViewModel: MasterViewModel){
    val image = painterResource(R.drawable.fondoprincipal)

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
            RelayContainer(
                Modifier.height(100.dp)
            ) {
                TitlepRc(modifier = Modifier.rowWeight(1.0f))
                Descrip2(modifier = Modifier.rowWeight(1.0f))
            }

            RelayContainer {
                CardAuxRc(modifier = Modifier.columnWeight(1.0f),navController,viewModel = viewModel)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CardAuxPrev(){
    SolicitarCotizacionTheme{
        CardAuxRc(Modifier,rememberNavController(), RegisterViewModel())
    }
}

@Composable
fun CardAuxRc(modifier: Modifier = Modifier, navController: NavController, viewModel: RegisterViewModel) {
    TopLevel(modifier = modifier) {
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                TipoDeDocumento()
                tipoDoc(viewModel = viewModel)
            }
            item {
                NMeroDeDocumento()
                numDoc(viewModel = viewModel)
            }
            item {
                Nombres()
                nombresField(viewModel = viewModel)
            }
            item {
                Apellidos()
                apellidosField(viewModel = viewModel)
            }
            item {
                FechaDeNacimiento()
                fechaNac(viewModel = viewModel)
            }
            item {
                CDigoPostal()
                codigoPostal(viewModel = viewModel)
            }
            item {
                DirecciN()
                direccionField(viewModel = viewModel)
            }
            item {
                Correo()
                correoField(viewModel = viewModel)
            }
            item {
                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

                ){
                    BtnConf(
                        onBtnConfirm = {
                            viewModel.agregarPersona()             },
                        modifier = Modifier.padding(top = 20.dp),
                    )
                }
            }
        }
    }
}


@Composable
fun TipoDeDocumento(modifier: Modifier = Modifier) {
    RelayText(
        content = "Tipo de documento",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(166.0.dp)
            .requiredHeight(20.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun NMeroDeDocumento(modifier: Modifier = Modifier) {
    RelayText(
        content = "Número de documento",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Nombres(modifier: Modifier = Modifier) {
    RelayText(
        content = "Nombres",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Apellidos(modifier: Modifier = Modifier) {
    RelayText(
        content = "Apellidos",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun FechaDeNacimiento(modifier: Modifier = Modifier) {
    RelayText(
        content = "Fecha de nacimiento",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun CDigoPostal(modifier: Modifier = Modifier) {
    RelayText(
        content = "Código postal",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun DirecciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Dirección",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Correo(modifier: Modifier = Modifier) {
    RelayText(
        content = "Correo",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(188.0.dp)
            .requiredHeight(24.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
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
            red = 236,
            green = 249,
            blue = 255
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 16.0.dp,
            top = 17.0.dp,
            end = 16.0.dp,
            bottom = 17.0.dp
        ),
        itemSpacing = 12.0,
        radius = 10.0,
        content = content,
        modifier = modifier.fillMaxHeight(1.0f)
    )
}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun tipoDoc(viewModel: RegisterViewModel){
    var expanded by remember { mutableStateOf(false) }
    val items = viewModel.tipoDocumentoResult.value
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
            Text(text = "Seleccione su tipo de documento")
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
        items.forEach { tipoDoc ->
            DropdownMenuItem(onClick = {
                selectedText = tipoDoc.descripcion
                expanded = false
                viewModel.tipoDocumentoSelected = tipoDoc.id_tipo_documento
            }) {
                Text(text = tipoDoc.descripcion)
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun codigoPostal(viewModel: RegisterViewModel){
    var expanded by remember { mutableStateOf(false) }
    val items = viewModel.ubigeoResult.value
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
        items.forEach { ubigeo ->
            DropdownMenuItem(onClick = {
                selectedText = ubigeo.idubigeo + " - " + ubigeo.departamento
                expanded = false
                viewModel.ubigeoSelected = ubigeo.idubigeo
            }) {
                Text(text = ubigeo.idubigeo + " - " + ubigeo.departamento)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun numDoc (modifier: Modifier = Modifier, viewModel: RegisterViewModel){
    val numDoc: String by viewModel.numDoc.observeAsState(initial = "")
    TextField(
        value = numDoc,
        onValueChange = { viewModel.onNumDocChange(it)},
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
            Text(text = "Ingrese su número de documento")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nombresField (modifier: Modifier = Modifier, viewModel: RegisterViewModel){

    val nombres: String by viewModel.nombres.observeAsState(initial = "")
    TextField(
        value = nombres,
        onValueChange = { viewModel.onNombresChange(it)},
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun apellidosField (modifier: Modifier = Modifier, viewModel: RegisterViewModel){

    val apellidos: String by viewModel.apellidos.observeAsState(initial = "")
    TextField(
        value = apellidos,
        onValueChange = { viewModel.onApellidosChange(it) },
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
            Text(text = "Ingrese sus apellidos")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun direccionField (modifier: Modifier = Modifier,viewModel: RegisterViewModel){
    val direccion: String by viewModel.direccion.observeAsState(initial = "")
    TextField(
        value = direccion,
        onValueChange = { viewModel.onDireccionChange(it)},
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
            Text(text = "Ingrese su dirección")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun correoField (modifier: Modifier = Modifier, viewModel: RegisterViewModel){

    val correo: String by viewModel.correo.observeAsState(initial = "")
    TextField(
        value = correo,
        onValueChange = { viewModel.onCorreoChange(it)},
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
@Composable()
fun fechaNac(modifier:Modifier = Modifier, viewModel: RegisterViewModel){
    val fechaNacimiento by viewModel.fechaNacimiento.observeAsState("Seleccione una fecha")
    val calendarState = rememberSheetState()
    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        selection = CalendarSelection.Date { date ->
            viewModel.onFechaNacimientoChange(date.toString())
        }
    )
    Button(
        onClick = { calendarState.show() },
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = fechaNacimiento,
        )
    }
}

@Preview(showBackground = false)
@Composable
fun RegisterPreview(){
    SolicitarCotizacionTheme{
        Register(rememberNavController(),RegisterViewModel(), MasterViewModel())
    }
}