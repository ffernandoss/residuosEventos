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
fun DrawLineChart(
    values: List<Float>,
    xLabels: List<String>,
    yLabel: String,
    lineColors: List<Color>
) {
    val maxValue = values.maxOrNull() ?: 0f
    val lineHeightFactor = 300.dp / (maxValue + 10) // Adding some padding

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

        val path = Path().apply {
            values.forEachIndexed { index, value ->
                val lineHeight = value * lineHeightFactor.toPx()
                val lineX = index * (canvasWidth / values.size)
                if (index == 0) {
                    moveTo(lineX, canvasHeight - lineHeight)
                } else {
                    lineTo(lineX, canvasHeight - lineHeight)
                }
            }
        }

        drawPath(
            path = path,
            color = lineColors.firstOrNull() ?: Color.Black,
            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 4.dp.toPx())
        )

        values.forEachIndexed { index, value ->
            val lineHeight = value * lineHeightFactor.toPx()
            val lineX = index * (canvasWidth / values.size)

            // Draw X axis labels with smaller text size
            drawContext.canvas.nativeCanvas.drawText(
                xLabels[index],
                lineX + (canvasWidth / values.size) / 2,
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