package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawDonutChart(
    values: List<Float>,
    colors: List<Color>
) {
    val total = values.sum()
    var startAngle = 0f
    val holeRadius = 100f // Adjust this value to change the size of the hole

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        values.forEachIndexed { index, value ->
            val sweepAngle = (value / total) * 360f
            drawArc(
                color = colors[index % colors.size],
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true
            )
            startAngle += sweepAngle
        }

        // Draw the hole in the center
        drawCircle(
            color = Color.White,
            radius = holeRadius,
            center = center
        )
    }
}