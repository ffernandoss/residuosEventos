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
fun DrawLineChart(
    values: List<Float>,
    xLabels: List<String>,
    yLabel: String,
    lineColor: Color
) {
    val maxValue = values.maxOrNull() ?: 0f
    val axisColor = Color.Black
    val axisStrokeWidth = 4f
    val pointRadius = 8f

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

        // Draw lines between points and points themselves
        values.forEachIndexed { index, value ->
            val currentX = index * pointSpacing
            val currentY = canvasHeight - (value * pointHeightFactor)

            if (index < values.size - 1) {
                val nextX = (index + 1) * pointSpacing
                val nextY = canvasHeight - (values[index + 1] * pointHeightFactor)

                drawLine(
                    color = lineColor,
                    start = androidx.compose.ui.geometry.Offset(currentX, currentY),
                    end = androidx.compose.ui.geometry.Offset(nextX, nextY),
                    strokeWidth = axisStrokeWidth
                )
            }

            // Draw point
            drawCircle(
                color = lineColor,
                radius = pointRadius,
                center = androidx.compose.ui.geometry.Offset(currentX, currentY)
            )

            // Draw X axis labels with smaller text size
            drawContext.canvas.nativeCanvas.drawText(
                xLabels[index],
                currentX,
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