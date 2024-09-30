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
    var selectedOption by remember { mutableStateOf("") }
    val options = listOf("Función 1", "Función 2", "Función 3", "Función 4", "Función 5", "Función 6", "Función 7")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                selectedOption = ""
                errorMessage = null
            } catch (e: NumberFormatException) {
                errorMessage = "Por favor, ingrese valores válidos."
            }
        }) {
            Text("Mostrar TODAS LAS FUNCIONES")
        }
        Spacer(modifier = Modifier.height(16.dp))
        errorMessage?.let {
            Text(text = it, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DropdownMenuButton(options = options, selectedOption = selectedOption) { option ->
            selectedOption = option
            showCharts = false
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (showCharts) {
            // Mostrar todas las funciones
            Text(text = "FUNCION 1", style = MaterialTheme.typography.headlineMedium)
            DrawBarChart(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), xLabels = listOf("valor 1", "valor 2", "valor 3"), yLabel = "Valores", barColor = Color.Blue)
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 2", style = MaterialTheme.typography.headlineMedium)
            BarChartScreen2(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 3", style = MaterialTheme.typography.headlineMedium)
            LineChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 4", style = MaterialTheme.typography.headlineMedium)
            PieChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 5", style = MaterialTheme.typography.headlineMedium)
            CircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 6", style = MaterialTheme.typography.headlineMedium)
            HalfCircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 7", style = MaterialTheme.typography.headlineMedium)
            AreaChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
        } else {
            // Mostrar solo la función seleccionada
            when (selectedOption) {
                "Función 1" -> {
                    Text(text = "FUNCION 1", style = MaterialTheme.typography.headlineMedium)
                    DrawBarChart(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), xLabels = listOf("valor 1", "valor 2", "valor 3"), yLabel = "Valores", barColor = Color.Blue)
                }
                "Función 2" -> {
                    Text(text = "FUNCION 2", style = MaterialTheme.typography.headlineMedium)
                    BarChartScreen2(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
                "Función 3" -> {
                    Text(text = "FUNCION 3", style = MaterialTheme.typography.headlineMedium)
                    LineChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
                "Función 4" -> {
                    Text(text = "FUNCION 4", style = MaterialTheme.typography.headlineMedium)
                    PieChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
                "Función 5" -> {
                    Text(text = "FUNCION 5", style = MaterialTheme.typography.headlineMedium)
                    CircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
                "Función 6" -> {
                    Text(text = "FUNCION 6", style = MaterialTheme.typography.headlineMedium)
                    HalfCircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
                "Función 7" -> {
                    Text(text = "FUNCION 7", style = MaterialTheme.typography.headlineMedium)
                    AreaChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()))
                }
            }
        }
    }
}

@Composable
fun DropdownMenuButton(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(text = "Elegir gráfico")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
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
fun HalfCircleChartScreen(values: List<Float>) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue)
    DrawHalfCircleChart(
        values = values,
        colors = colors
    )
}

@Composable
fun AreaChartScreen(values: List<Float>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"
    val areaColor = Color.Cyan

    DrawAreaChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        areaColor = areaColor
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

@Composable
fun DrawHalfCircleChart(
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
            val sweepAngle = (value / total) * 180f // Only 180 degrees
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
        val path = androidx.compose.ui.graphics.Path().apply {
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