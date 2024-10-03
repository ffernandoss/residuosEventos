package com.example.myapplication.Tablas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.myapplication.ui.theme.MyApplicationTheme

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar el modo de borde a borde
        enableEdgeToEdge()
        // Establecer el contenido de la actividad usando Jetpack Compose
        setContent {
            MyApplicationTheme {
                // Crear un Scaffold que llena todo el tamaño de la pantalla
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Llamar a la función MainScreen y pasar el padding interno
                    MainScreen(modifier = Modifier.padding(innerPadding)) {
                        // Crear un Intent para iniciar la SegundaActividad
                        val intent = Intent(this, SegundaActividad::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

// Función composable que define la pantalla principal
@Composable
fun MainScreen(modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    // Crear una columna que llena todo el tamaño de la pantalla
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar un texto con el título
        Text(text = "PARTE GRAFICAS", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        // Botón que llama a la función onButtonClick cuando se hace clic
        Button(onClick = onButtonClick) {
            Text(text = "Mostrar todas las gráficas conjuntas")
        }
    }
}

// Función de vista previa para el diseño de la pantalla principal
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MainScreen(onButtonClick = { })
    }
}