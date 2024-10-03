package com.example.myapplication.Tablas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun DrawBarChart(
    values: List<Float>,
    xLabels: List<String>,
    yLabel: String,
    barColors: List<Color>,
    showValues: Boolean = true
) {
    // Obtener el valor máximo de la lista de valores
    val maxValue = values.maxOrNull() ?: 0f
    // Definir el ancho de las barras y el espacio entre ellas
    val barWidth = 50.dp
    val barSpacing = 20.dp
    // Definir el color y el grosor de los ejes
    val axisColor = Color.Black
    val axisStrokeWidth = 4f

    // Crear un Canvas con un ancho completo y una altura de 300 dp
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        // Factor de altura de las barras, añadiendo un poco de padding
        val barHeightFactor = canvasHeight / (maxValue + 10)

        // Dibujar el eje Y
        drawLine(
            color = axisColor,
            start = androidx.compose.ui.geometry.Offset(0f, 0f),
            end = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            strokeWidth = axisStrokeWidth
        )

        // Dibujar el eje X
        drawLine(
            color = axisColor,
            start = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            end = androidx.compose.ui.geometry.Offset(canvasWidth, canvasHeight),
            strokeWidth = axisStrokeWidth
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

        // Dibujar las barras y las etiquetas del eje X
        values.forEachIndexed { index, value ->
            val barHeight = value * barHeightFactor
            val barX = index * (barWidth.toPx() + barSpacing.toPx())
            drawRect(
                color = barColors[index],
                topLeft = androidx.compose.ui.geometry.Offset(barX, canvasHeight - barHeight),
                size = androidx.compose.ui.geometry.Size(barWidth.toPx(), barHeight)
            )

            if (showValues) {
                // Dibujar las etiquetas de los valores encima de las barras
                drawContext.canvas.nativeCanvas.drawText(
                    value.toString(),
                    barX + barWidth.toPx() / 2,
                    canvasHeight - barHeight - 10,
                    android.graphics.Paint().apply {
                        textSize = 40f
                        color = android.graphics.Color.BLACK
                        textAlign = android.graphics.Paint.Align.CENTER
                    }
                )
            }

            // Dibujar las etiquetas del eje X con un tamaño de texto más pequeño
            drawContext.canvas.nativeCanvas.drawText(
                xLabels[index],
                barX + barWidth.toPx() / 2,
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