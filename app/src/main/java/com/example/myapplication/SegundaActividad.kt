package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class SegundaActividad : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                BarChartScreen()
            }
        }
    }
}

@Composable
fun BarChartScreen() {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var showCharts by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var barColor by remember { mutableStateOf(Color.Blue) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section for Function 1
        Text(text = "FUNCION 1", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Valor 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Valor 2") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Valor 3") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            try {
                showCharts = true
                errorMessage = null
            } catch (e: NumberFormatException) {
                errorMessage = "Por favor, ingrese valores válidos."
            }
        }) {
            Text("Mostrar Diagramas de Barras")
        }
        Spacer(modifier = Modifier.height(16.dp))
        errorMessage?.let {
            Text(text = it, color = Color.Red)
        }
        if (showCharts) {
            DrawBarChart(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()),
                xLabels = listOf("valor 1", "valor 2", "Valor 3"),
                yLabel = "Valores",
                barColor = barColor
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "FUNCION 2", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            BarChartScreen2(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat())
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "FUNCION 3", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LineChartScreen(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat())
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "FUNCION 4", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            PieChartScreen(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat())
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "FUNCION 5", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            CircleChartScreen(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat())
            )
        }
    }
}

@Composable
fun BarChartScreen2(values: List<Float>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"
    val barColor = Color.Green

    DrawBarChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        barColor = barColor,
        showValues = false
    )
}

@Composable
fun LineChartScreen(values: List<Float>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"
    val lineColor = Color.Red

    DrawLineChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        lineColor = lineColor
    )
}

@Composable
fun PieChartScreen(values: List<Float>) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue)
    DrawPieChart(
        values = values,
        colors = colors
    )
}

@Composable
fun CircleChartScreen(values: List<Float>) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue)
    DrawDonutChart(
        values = values,
        colors = colors
    )
}

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
        .fillMaxWidth()
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

@Composable
fun DrawPieChart(
    values: List<Float>,
    colors: List<Color>
) {
    val total = values.sum()
    var startAngle = 0f

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
    }
}

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