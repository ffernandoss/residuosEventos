package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun DrawAreaChart(
    values: List<Float>,
    xLabels: List<String>,
    yLabel: String,
    areaColors: List<Color>
) {
    // Obtener el valor máximo de la lista de valores
    val maxValue = values.maxOrNull() ?: 0f
    // Factor de altura del área, añadiendo un poco de padding
    val areaHeightFactor = 300.dp / (maxValue + 10)

    // Crear un Canvas con un ancho completo y una altura de 300 dp
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Dibujar el eje Y
        drawLine(
            color = Color.Black,
            start = androidx.compose.ui.geometry.Offset(0f, 0f),
            end = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            strokeWidth = 4f
        )

        // Dibujar el eje X
        drawLine(
            color = Color.Black,
            start = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            end = androidx.compose.ui.geometry.Offset(canvasWidth, canvasHeight),
            strokeWidth = 4f
        )

        // Dibujar la etiqueta del eje Y
        drawContext.canvas.nativeCanvas.drawText(
            yLabel,
            10f,
            20f,
            android.graphics.Paint().apply {
                textSize = 40f
                color = android.graphics.Color.BLACK
            }
        )

        // Dibujar las áreas y las etiquetas del eje X
        values.forEachIndexed { index, value ->
            val areaHeight = value * areaHeightFactor.toPx()
            val areaX = index * (canvasWidth / values.size)

            // Dibujar el área
            drawRect(
                color = areaColors[index],
                topLeft = androidx.compose.ui.geometry.Offset(areaX, canvasHeight - areaHeight),
                size = androidx.compose.ui.geometry.Size(canvasWidth / values.size, areaHeight)
            )

            // Dibujar las etiquetas del eje X con un tamaño de texto más pequeño
            drawContext.canvas.nativeCanvas.drawText(
                xLabels[index],
                areaX + (canvasWidth / values.size) / 2,
                canvasHeight + 40,
                android.graphics.Paint().apply {
                    textSize = 40f
                    color = android.graphics.Color.BLACK
                    textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }
    }
}