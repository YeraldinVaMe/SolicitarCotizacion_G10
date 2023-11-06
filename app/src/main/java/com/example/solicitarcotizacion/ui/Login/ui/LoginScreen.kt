package com.example.solicitarcotizacion.ui.Login.ui

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.solicitarcotizacion.Navigation.Screen
import com.example.solicitarcotizacion.R

import com.example.solicitarcotizacion.titleprincipal.TitlePrincipal
import com.example.solicitarcotizacion.ui.theme.SolicitarCotizacionTheme

import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable


@Composable
fun Login(navController: NavController){

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RelayContainer(
                modifier = Modifier.padding(bottom = 100.dp, top = 50.dp)
            ){
                TitlePrincipal(textCondosa = "Condosa")
            }
            RelayContainer {
                CardPrinccp(
                    onGrupoInittapped = {navController.navigate(Screen.MenuPrincipal.route)},
                    oninitRtapped = {navController.navigate(Screen.Register.route)},
                    oninittapped = {},
                    onregsstapped = {navController.navigate(Screen.Register.route)}
                )
            }
        }
    }
}

@Composable
fun CardPrinccp(
    modifier: Modifier = Modifier,
    onGrupoInittapped: () -> Unit = {},
    oninitRtapped: () -> Unit = {},
    oninittapped: () -> Unit = {},
    onregsstapped: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        GroupPrincipp {
            InitR(
                oninitRtapped = oninitRtapped,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            ) {
                Rectangle59(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
                Registrarse(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
            Init(
                oninittapped = oninittapped,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            ) {
                Rectangle60(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
                IniciarSesiN(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
        }
        BienvenidoACONDOSA()
        Celectronico()
        emailInput()
        Con()
        passInput()
        GrupoInit(onGrupoInittapped = onGrupoInittapped) {
            Rectangle39(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
            Issss(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
        }
        GroupRegs {
            Notc(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
            Regss(
                onregsstapped = onregsstapped,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Rectangle59(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_princcp_rectangle_59),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Registrarse(modifier: Modifier = Modifier) {
    RelayText(
        content = "Registrarse",
        fontSize = 18.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
        color = Color(
            alpha = 255,
            red = 236,
            green = 249,
            blue = 255
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 181.0.dp,
                    top = 17.0.dp,
                    end = 0.0.dp,
                    bottom = 7.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun InitR(
    oninitRtapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 40.0,
        content = content,
        modifier = modifier
            .tappable(onTap = oninitRtapped)
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Rectangle60(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_princcp_rectangle_60),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun IniciarSesiN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Iniciar Sesión",
        fontSize = 18.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 15.0.dp,
                    top = 17.0.dp,
                    end = 0.0.dp,
                    bottom = 7.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Init(
    oninittapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 40.0,
        content = content,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 0.0.dp,
                    top = 0.0.dp,
                    end = 139.0.dp,
                    bottom = 0.0.dp
                )
            )
            .tappable(onTap = oninittapped)
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun GroupPrincipp(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 40.0,
        content = content,
        modifier = modifier
            .requiredWidth(308.0.dp)
            .requiredHeight(58.0.dp)
    )
}

@Composable
fun BienvenidoACONDOSA(modifier: Modifier = Modifier) {
    RelayText(
        content = "Bienvenido a CONDOSA",
        fontSize = 23.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
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
            .requiredWidth(287.0.dp)
            .requiredHeight(34.0.dp)
    )
}

@Composable
fun Celectronico(modifier: Modifier = Modifier) {
    RelayText(
        content = "Correo electrónico:",
        fontSize = 17.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
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
fun Rff12(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_princcp_rff12),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Fas3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
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
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
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
fun Rec55(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_princcp_rec55),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Reca32(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(307.0.dp)
            .requiredHeight(34.0.dp)
    )
}

@Composable
fun Rectangle39(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.card_princcp_rectangle_39),
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Issss(modifier: Modifier = Modifier) {
    RelayText(
        content = "Iniciar Sesión",
        fontSize = 18.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.5.em,
        fontWeight = FontWeight(700.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 70.0.dp,
                    top = 12.0.dp,
                    end = 70.0.dp,
                    bottom = 12.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun GrupoInit(
    onGrupoInittapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        radius = 40.0,
        content = content,
        modifier = modifier
            .tappable(onTap = onGrupoInittapped)
            .requiredWidth(308.0.dp)
            .requiredHeight(58.0.dp)
    )
}

@Composable
fun Notc(modifier: Modifier = Modifier) {
    RelayText(
        content = "¿No tienes una cuenta?",
        fontSize = 13.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier
            .padding(
                paddingValues = PaddingValues(
                    start = 0.0.dp,
                    top = 0.0.dp,
                    end = 58.549560546875.dp,
                    bottom = 0.0.dp
                )
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun Regss(
    onregsstapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "Registrarse",
        fontSize = 13.0.sp,
        fontFamily = com.example.solicitarcotizacion.cardprinccp.poppins,
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
            .padding(
                paddingValues = PaddingValues(
                    start = 158.77880859375.dp,
                    top = 0.0.dp,
                    end = 0.0.dp,
                    bottom = 0.0.dp
                )
            )
            .tappable(onTap = onregsstapped)
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun GroupRegs(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .requiredWidth(260.0.dp)
            .requiredHeight(34.0.dp)
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
            top = 10.0.dp,
            end = 15.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 26.0,
        radius = 40.0,
        content = content,
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun emailInput(modifier: Modifier = Modifier){

    var emailInput by remember { mutableStateOf("") }

    OutlinedTextField(
        value = emailInput,
        onValueChange = { emailInput = it },
        textStyle = TextStyle(
            fontSize = 18.0.sp,
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            textAlign = TextAlign.Left
        ),
        modifier = modifier.height(65.dp),
        label = {
            Text(text = "")
        },
        placeholder = {
            Text(text = "Ingresa tu correo")
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passInput(modifier: Modifier = Modifier){

    var passInput by remember { mutableStateOf("") }

    OutlinedTextField(
        value = passInput,
        onValueChange = { passInput = it },
        textStyle = TextStyle(
            fontSize = 18.0.sp,
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            textAlign = TextAlign.Left
        ),
        modifier = modifier.height(65.dp),
        label = {
            Text(text = "")
        },
        placeholder = {
            Text(text = "Ingresa tu contraseña")
        },
        isError = false,
        visualTransformation = PasswordVisualTransformation()
    )
}


@Preview(showBackground = false)
@Composable
fun LoginPreview(){
    SolicitarCotizacionTheme{
        Login(rememberNavController())
    }
}