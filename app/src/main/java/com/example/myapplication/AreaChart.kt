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
    val maxValue = values.maxOrNull() ?: 0f
    val areaHeightFactor = 300.dp / (maxValue + 10) // Adding some padding

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Draw Y axis
        drawLine(
            color = Color.Black,
            start = androidx.compose.ui.geometry.Offset(0f, 0f),
            end = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            strokeWidth = 4f
        )

        // Draw X axis
        drawLine(
            color = Color.Black,
            start = androidx.compose.ui.geometry.Offset(0f, canvasHeight),
            end = androidx.compose.ui.geometry.Offset(canvasWidth, canvasHeight),
            strokeWidth = 4f
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

        values.forEachIndexed { index, value ->
            val areaHeight = value * areaHeightFactor.toPx()
            val areaX = index * (canvasWidth / values.size)

            drawRect(
                color = areaColors[index],
                topLeft = androidx.compose.ui.geometry.Offset(areaX, canvasHeight - areaHeight),
                size = androidx.compose.ui.geometry.Size(canvasWidth / values.size, areaHeight)
            )

            // Draw X axis labels with smaller text size
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