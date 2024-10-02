package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.myapplication.R

@Composable
fun MapaReciclajeMadrid() {
    Image(
        painter = painterResource(id = R.drawable.mapa_reciclaje_madrid),
        contentDescription = "Mapa de los puntos de reciclaje de Madrid",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun MapaReciclajeMadridPreview() {
    MapaReciclajeMadrid()
}