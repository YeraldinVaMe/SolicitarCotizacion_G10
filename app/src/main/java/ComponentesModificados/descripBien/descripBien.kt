package ComponentesModificados.descripBien

import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText

@Composable
fun descripBien(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        BienvenidoASeleccionaLaActividadARealizar()
    }
}

@Preview(widthDp = 308, heightDp = 120)
@Composable
private fun descripBienPreview() {
    MaterialTheme {
       descripBien()
    }
}

@Composable
fun BienvenidoASeleccionaLaActividadARealizar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Bienvenido(a)\n\nSelecciona la actividad a realizar:",
        fontSize = 20.0.sp,
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
        modifier = modifier.requiredWidth(308.0.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}