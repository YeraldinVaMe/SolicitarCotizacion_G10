package com.example.solicitarcotizacion.ui.Login

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R
import com.example.solicitarcotizacion.cardloginv1.poppins

import com.example.solicitarcotizacion.titleprincipal.TitlePrincipal
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
fun Login(navController: NavController, viewModel: LoginViewModel){

    val image = painterResource(R.drawable.fondoprincipal)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer(
                modifier = Modifier
                    .padding(bottom = 60.dp, top = 50.dp)
                    .fillMaxWidth()
            ){
                TitlePrincipal(textCondosa = "Condosa", modifier = Modifier.scale(0.9F))
            }
            RelayContainer(
                Modifier
                    .fillMaxHeight()
                    .padding(all = 15.dp)
            ) {
                CardLoginv1(
                    onBtnIniciarSesion = {navController.navigate(Screen.MenuPrincipal.route)},
                    onBtnRegistrarse = {navController.navigate(Screen.Register.route)},
                    ontextRegistrarse = {navController.navigate(Screen.Register.route)},
                    viewModel = viewModel
                )
            }
        }
    }
}


//CARD DEL LOGIN
@Composable
fun CardLoginv1(
    modifier: Modifier = Modifier,
    onBtnRegistrarse: () -> Unit = {},
    onBtnIniciarSesion: () -> Unit = {},
    ontextRegistrarse: () -> Unit = {},
    viewModel: LoginViewModel
) {
    TopLevel(modifier = modifier) {
        BtnRegistrarse(onBtnRegistrarse = onBtnRegistrarse) {
            Registrarse()
        }
        BienvenidoACONDOSA()
        Celectronico()
        correoField(viewModel = viewModel)
        Con()
        passInput(viewModel = viewModel)
        BtnIniciarSesion(onBtnIniciarSesion = onBtnIniciarSesion) {
            IniciarSesiN()
        }
        GroupRegs {
            NoTienesUnaCuenta()
            TextRegistrarse(ontextRegistrarse = ontextRegistrarse)
        }
    }
}

@Composable
fun Registrarse(modifier: Modifier = Modifier) {
    RelayText(
        content = "Registrarse",
        fontSize = 18.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 236,
            green = 249,
            blue = 255
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun BtnRegistrarse(
    onBtnRegistrarse: () -> Unit,
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
            start = 0.0.dp,
            top = 7.0.dp,
            end = 0.0.dp,
            bottom = 7.0.dp
        ),
        itemSpacing = 10.0,
        radius = 40.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnRegistrarse)
            .requiredWidth(308.0.dp)
            .requiredHeight(58.0.dp)
    )
}

@Composable
fun BienvenidoACONDOSA(modifier: Modifier = Modifier) {
    RelayText(
        content = "Bienvenido a CONDOSA",
        fontSize = 23.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredHeight(34.0.dp)
    )
}

@Composable
fun Celectronico(modifier: Modifier = Modifier) {
    RelayText(
        content = "Correo electrónico:",
        fontSize = 17.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(297.0.dp)
            .requiredHeight(20.0.dp)
    )
}

@Composable
fun Rectangle60(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_loginv1_rectangle_60),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(34.0.dp)
    )
}

@Composable
fun Con(modifier: Modifier = Modifier) {
    RelayText(
        content = "Contraseña:",
        fontSize = 17.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(300.0.dp)
            .requiredHeight(20.0.dp)
    )
}

@Composable
fun Rectangle61(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_loginv1_rectangle_61),
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(34.0.dp)
    )
}

@Composable
fun IniciarSesiN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Iniciar Sesión",
        fontSize = 18.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun BtnIniciarSesion(
    onBtnIniciarSesion: () -> Unit,
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
            start = 70.0.dp,
            top = 12.0.dp,
            end = 70.0.dp,
            bottom = 12.0.dp
        ),
        itemSpacing = 10.0,
        radius = 40.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onBtnIniciarSesion)
            .requiredWidth(308.0.dp)
            .requiredHeight(58.0.dp)
    )
}

@Composable
fun NoTienesUnaCuenta(modifier: Modifier = Modifier) {
    RelayText(
        content = "¿No tienes una cuenta?",
        fontSize = 13.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.requiredHeight(34.0.dp)
    )
}

@Composable
fun TextRegistrarse(
    ontextRegistrarse: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "Registrarse",
        fontSize = 13.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 47,
            green = 88,
            blue = 205
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        underline = true,
        maxLines = -1,
        shadow = Shadow(
            color = Color(
                alpha = 25,
                red = 0,
                green = 0,
                blue = 0
            ),
            offset = Offset(
                x = 0.0f,
                y = 4.0f
            ),
            blurRadius = 25.0f
        ),
        modifier = modifier
            .tappable(onTap = ontextRegistrarse)
            .requiredWidth(102.0.dp)
            .requiredHeight(34.0.dp)
    )
}

@Composable
fun GroupRegs(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 7.0,
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
            red = 236,
            green = 249,
            blue = 255
        ),
        padding = PaddingValues(
            start = 15.0.dp,
            top = 20.0.dp,
            end = 15.0.dp,
            bottom = 8.0.dp
        ),
        itemSpacing = 30.0,
        radius = 40.0,
        content = content,
        modifier = modifier
    )
}

@Preview(showBackground = false)
@Composable
fun LoginPreview(){
    SolicitarCotizacionTheme{
        Login(rememberNavController(), LoginViewModel())
    }
}

//FIELDS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun correoField (modifier: Modifier = Modifier, viewModel: LoginViewModel){

    val correo : String by viewModel.correo.observeAsState(initial = "")

    TextField(
        value = correo,
        onValueChange = { viewModel.onCorreoChange(it) },
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
fun passInput(modifier: Modifier = Modifier, viewModel: LoginViewModel){

    val pass : String by viewModel.pass.observeAsState(initial = "")

    TextField(
        value = pass,
        onValueChange = { viewModel.onPassChange(it) },
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
            Text(text = "Ingresa tu contraseña")
        },
        isError = false,
        visualTransformation = PasswordVisualTransformation()
    )
}