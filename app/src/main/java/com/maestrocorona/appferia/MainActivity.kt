package com.maestrocorona.appferia

// Importaciones necesarias
import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview // Importación necesaria para usar @Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitamos el diseño sin bordes
        enableEdgeToEdge()

        // Definimos el contenido de la actividad
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                startActivity(Intent(this, Activity2::class.java)) // Abre Activity2 cuando se presiona el botón
            })
        }
    }
}

// Composable que representa la pantalla principal
@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(), // Ocupar toda la pantalla
        color = MaterialTheme.colorScheme.background // Usamos el color de fondo del tema
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Agregamos tarjetas con información de negocios
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y Conciertos") // 🎡 Nueva Card añadida aquí

            // Botón para ir a otra pantalla con información de "Fechas importantes"
            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

// Composable reutilizable para mostrar una tarjeta con imagen y texto
@Composable
fun BusinessItem(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A0E4A) // Color morado oscuro de fondo
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen representando el negocio
            Image(
                painter = painterResource(id = R.drawable.logo_rest), // Usamos la imagen del recurso drawable
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            // Texto con el nombre del negocio o sección
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                color = Color.White // Color blanco para que resalte sobre el fondo oscuro
            )
        }
    }
}

// Preview para visualizar una sola Card en el editor
@Preview(showBackground = true, name = "Vista previa de una Card")
@Composable
fun PreviewBusinessItem() {
    BusinessItem("Ejemplo de Card")
}

//  Preview para ver la pantalla principal completa en el editor
@Preview(showBackground = true, name = "Vista previa de la pantalla principal")
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {}) // No hace nada en el preview
}
