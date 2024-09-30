package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun DrawAreaChart(
    values: List<Float>,
    xLabels: List<String>,
    yLabel: String,
    areaColor: Color
) {
    val maxValue = values.maxOrNull() ?: 0f
    val axisColor = Color.Black
    val axisStrokeWidth = 4f

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val pointSpacing = canvasWidth / (values.size - 1)
        val pointHeightFactor = canvasHeight / (maxValue + 10) // Adding some padding

        // Draw Y axis
        drawLine(
            color = axisColor,
            start = androidx.compose.ui.geometry.Offset(0f, 0f),
            end = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            strokeWidth = axisStrokeWidth
        )

        // Draw X axis
        drawLine(
            color = axisColor,
            start = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            end = androidx.compose.ui.geometry.Offset(canvasWidth, canvasHeight),
            strokeWidth = axisStrokeWidth
        )

        // Draw Y axis label
        drawContext.canvas.nativeCanvas.drawText(
            yLabel,
            10f,
            20f,
            android.graphics.Paint().apply {
                textSize = 40f
                color = android.graphics.Color.BLACK
            }
        )

        // Draw area
        val path = Path().apply {
            moveTo(0f, canvasHeight)
            values.forEachIndexed { index, value ->
                val x = index * pointSpacing
                val y = canvasHeight - (value * pointHeightFactor)
                lineTo(x, y)
            }
            lineTo(canvasWidth, canvasHeight)
            close()
        }
        drawPath(
            path = path,
            color = areaColor
        )

        // Draw X axis labels with smaller text size
        values.forEachIndexed { index, _ ->
            val x = index * pointSpacing
            drawContext.canvas.nativeCanvas.drawText(
                xLabels[index],
                x,
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