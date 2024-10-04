package com.example.myapplication.Tablas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorPicker(selectedColor: Color, onColorSelected: (Color) -> Unit) {
    // Variable para controlar si el menú desplegable está expandido o no
    var expanded by remember { mutableStateOf(false) }
    // Lista de colores disponibles para seleccionar
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan, Color.Magenta)

    Box {
        // Botón que al hacer clic expande el menú desplegable
        Button(onClick = { expanded = true }) {
            Text("Cambiar Color")
        }
        // Menú desplegable que muestra la lista de colores
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } // Cierra el menú cuando se hace clic fuera de él
        ) {
            // Itera sobre la lista de colores y crea un elemento de menú para cada color
            colors.forEach { color ->
                DropdownMenuItem(
                    text = {
                        // Caja que muestra el color
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(color)
                        )
                    },
                    onClick = {
                        // Llama a la función onColorSelected con el color seleccionado y cierra el menú
                        onColorSelected(color)
                        expanded = false
                    }
                )
            }
        }
    }
}