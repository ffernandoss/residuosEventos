package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp // Importar dp
import com.example.myapplication.Tablas.MainActivity // Importar Pantalla4Main
import com.example.myapplication.R

class MapaResiduos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapaReciclajeMadrid()
        }
    }
}

// Función composable que muestra el mapa donde hay puntos de reciclaje de Madrid
@Composable
fun MapaReciclajeMadrid() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.mapa_reciclaje_madrid), // Carga la imagen del mapa
            contentDescription = "Mapa de los puntos de reciclaje de Madrid", // Descripción de la imagen
            modifier = Modifier.weight(1f), // Modificador para llenar todo el tamaño disponible
            contentScale = ContentScale.Crop // Escalar la imagen para llenar el contenedor
        )
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = "Siguiente")
        }
    }
}

// Función de vista previa
@Preview(showBackground = true)
@Composable
fun MapaReciclajeMadridPreview() {
    MapaReciclajeMadrid()
}