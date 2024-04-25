import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    val botonClick=usuario.isNotEmpty() && contraseña.isNotEmpty()

    MaterialTheme {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp,alignment= Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize()
        ){
            OutlinedTextField(
                value= usuario,
                onValueChange={usuario=it},
                label = { Text("Usuario",
                    modifier = Modifier.background(color= Color.White)) })

            OutlinedTextField(
                value= contraseña,
                onValueChange={contraseña=it},
                label={ Text("Contraseña",
                    modifier = Modifier.background(color= Color.White)) },
                visualTransformation = if(visible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon={
                    IconToggleButton(checked= visible,onCheckedChange = {visible=it}){
                        Icon(
                            imageVector = if(visible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription=null)
                    }
                })

            Button(
                onClick = {
                    },
                enabled = botonClick){
                Text(text="Iniciar")
            }

            Button(onClick = {}){
                Text(text="Registrar")
            }
        }


    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
