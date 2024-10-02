package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.myapplication.R

// Función composable que muestra el mapa donde hay puntos de reciclaje de Madrid
@Composable
fun MapaReciclajeMadrid() {
    Image(
        painter = painterResource(id = R.drawable.mapa_reciclaje_madrid), // Carga la imagen del mapa
        contentDescription = "Mapa de los puntos de reciclaje de Madrid", // Descripción de la imagen
        modifier = Modifier.fillMaxSize(), // Modificador para llenar todo el tamaño disponible
        contentScale = ContentScale.Crop // Escalar la imagen para llenar el contenedor
    )
}

// Función de vista previa
@Preview(showBackground = true)
@Composable
fun MapaReciclajeMadridPreview() {
    MapaReciclajeMadrid()
}