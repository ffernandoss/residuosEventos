package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
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
    barColor: Color,
    showValues: Boolean = true
) {
    val maxValue = values.maxOrNull() ?: 0f
    val barWidth = 50.dp
    val barSpacing = 20.dp
    val axisColor = Color.Black
    val axisStrokeWidth = 4f

    Canvas(modifier = Modifier
        .fillMaxSize()
        .height(300.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val barHeightFactor = canvasHeight / (maxValue + 10) // Adding some padding

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

        values.forEachIndexed { index, value ->
            val barHeight = value * barHeightFactor
            val barX = index * (barWidth.toPx() + barSpacing.toPx())
            drawRect(
                color = barColor,
                topLeft = androidx.compose.ui.geometry.Offset(barX, canvasHeight - barHeight),
                size = androidx.compose.ui.geometry.Size(barWidth.toPx(), barHeight)
            )

            if (showValues) {
                // Draw value labels above bars
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

            // Draw X axis labels with smaller text size
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