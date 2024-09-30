package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var showDialog by remember { mutableStateOf(false) }

    // Colors for each function
    var color1Func1 by remember { mutableStateOf(Color.Blue) }
    var color2Func1 by remember { mutableStateOf(Color.Green) }
    var color3Func1 by remember { mutableStateOf(Color.Red) }

    var color1Func2 by remember { mutableStateOf(Color.Blue) }
    var color2Func2 by remember { mutableStateOf(Color.Green) }
    var color3Func2 by remember { mutableStateOf(Color.Red) }

    var color1Func3 by remember { mutableStateOf(Color.Blue) }

    var color1Func4 by remember { mutableStateOf(Color.Blue) }
    var color2Func4 by remember { mutableStateOf(Color.Green) }
    var color3Func4 by remember { mutableStateOf(Color.Red) }

    var color1Func5 by remember { mutableStateOf(Color.Blue) }
    var color2Func5 by remember { mutableStateOf(Color.Green) }
    var color3Func5 by remember { mutableStateOf(Color.Red) }

    var color1Func6 by remember { mutableStateOf(Color.Blue) }
    var color2Func6 by remember { mutableStateOf(Color.Green) }
    var color3Func6 by remember { mutableStateOf(Color.Red) }

    var color1Func7 by remember { mutableStateOf(Color.Blue) }
    var color2Func7 by remember { mutableStateOf(Color.Green) }
    var color3Func7 by remember { mutableStateOf(Color.Red) }

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
                if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty()) {
                    errorMessage = "Todos los campos deben estar llenos."
                    showDialog = true
                } else {
                    value1.toFloat()
                    value2.toFloat()
                    value3.toFloat()
                    showCharts = true
                    selectedOption = ""
                    errorMessage = null
                }
            } catch (e: NumberFormatException) {
                errorMessage = "Por favor, ingrese valores numéricos válidos."
                showDialog = true
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
            ColorPicker(selectedColor = color1Func1) { color1Func1 = it }
            ColorPicker(selectedColor = color2Func1) { color2Func1 = it }
            ColorPicker(selectedColor = color3Func1) { color3Func1 = it }
            DrawBarChart(
                values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()),
                xLabels = listOf("valor 1", "valor 2", "valor 3"),
                yLabel = "Valores",
                barColors = listOf(color1Func1, color2Func1, color3Func1)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 2", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func2) { color1Func2 = it }
            ColorPicker(selectedColor = color2Func2) { color2Func2 = it }
            ColorPicker(selectedColor = color3Func2) { color3Func2 = it }
            BarChartScreen2(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func2, color2Func2, color3Func2))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 3", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func3) { color1Func3 = it }
            LineChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func3, color1Func3, color1Func3))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 4", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func4) { color1Func4 = it }
            ColorPicker(selectedColor = color2Func4) { color2Func4 = it }
            ColorPicker(selectedColor = color3Func4) { color3Func4 = it }
            PieChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func4, color2Func4, color3Func4))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 5", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func5) { color1Func5 = it }
            ColorPicker(selectedColor = color2Func5) { color2Func5 = it }
            ColorPicker(selectedColor = color3Func5) { color3Func5 = it }
            CircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func5, color2Func5, color3Func5))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 6", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func6) { color1Func6 = it }
            ColorPicker(selectedColor = color2Func6) { color2Func6 = it }
            ColorPicker(selectedColor = color3Func6) { color3Func6 = it }
            HalfCircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func6, color2Func6, color3Func6))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FUNCION 7", style = MaterialTheme.typography.headlineMedium)
            ColorPicker(selectedColor = color1Func7) { color1Func7 = it }
            ColorPicker(selectedColor = color2Func7) { color2Func7 = it }
            ColorPicker(selectedColor = color3Func7) { color3Func7 = it }
            AreaChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func7, color2Func7, color3Func7))
        } else {
            // Mostrar solo la función seleccionada
            when (selectedOption) {
                "Función 1" -> {
                    Text(text = "FUNCION 1", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func1) { color1Func1 = it }
                    ColorPicker(selectedColor = color2Func1) { color2Func1 = it }
                    ColorPicker(selectedColor = color3Func1) { color3Func1 = it }
                    DrawBarChart(
                        values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()),
                        xLabels = listOf("valor 1", "valor 2", "valor 3"),
                        yLabel = "Valores",
                        barColors = listOf(color1Func1, color2Func1, color3Func1)
                    )
                }
                "Función 2" -> {
                    Text(text = "FUNCION 2", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func2) { color1Func2 = it }
                    ColorPicker(selectedColor = color2Func2) { color2Func2 = it }
                    ColorPicker(selectedColor = color3Func2) { color3Func2 = it }
                    BarChartScreen2(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func2, color2Func2, color3Func2))
                }
                "Función 3" -> {
                    Text(text = "FUNCION 3", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func3) { color1Func3 = it }
                    LineChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func3, color1Func3, color1Func3))
                }
                "Función 4" -> {
                    Text(text = "FUNCION 4", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func4) { color1Func4 = it }
                    ColorPicker(selectedColor = color2Func4) { color2Func4 = it }
                    ColorPicker(selectedColor = color3Func4) { color3Func4 = it }
                    PieChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func4, color2Func4, color3Func4))
                }
                "Función 5" -> {
                    Text(text = "FUNCION 5", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func5) { color1Func5 = it }
                    ColorPicker(selectedColor = color2Func5) { color2Func5 = it }
                    ColorPicker(selectedColor = color3Func5) { color3Func5 = it }
                    CircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func5, color2Func5, color3Func5))
                }
                "Función 6" -> {
                    Text(text = "FUNCION 6", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func6) { color1Func6 = it }
                    ColorPicker(selectedColor = color2Func6) { color2Func6 = it }
                    ColorPicker(selectedColor = color3Func6) { color3Func6 = it }
                    HalfCircleChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func6, color2Func6, color3Func6))
                }
                "Función 7" -> {
                    Text(text = "FUNCION 7", style = MaterialTheme.typography.headlineMedium)
                    ColorPicker(selectedColor = color1Func7) { color1Func7 = it }
                    ColorPicker(selectedColor = color2Func7) { color2Func7 = it }
                    ColorPicker(selectedColor = color3Func7) { color3Func7 = it }
                    AreaChartScreen(values = listOf(value1.toFloat(), value2.toFloat(), value3.toFloat()), colors = listOf(color1Func7, color2Func7, color3Func7))
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Error") },
            text = { Text(errorMessage ?: "") }
        )
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
fun BarChartScreen2(values: List<Float>, colors: List<Color>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"

    DrawBarChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        barColors = colors,
        showValues = false
    )
}

@Composable
fun LineChartScreen(values: List<Float>, colors: List<Color>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"

    DrawLineChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        lineColors = colors
    )
}

@Composable
fun PieChartScreen(values: List<Float>, colors: List<Color>) {
    DrawPieChart(
        values = values,
        colors = colors
    )
}

@Composable
fun CircleChartScreen(values: List<Float>, colors: List<Color>) {
    DrawDonutChart(
        values = values,
        colors = colors
    )
}

@Composable
fun HalfCircleChartScreen(values: List<Float>, colors: List<Color>) {
    DrawHalfCircleChart(
        values = values,
        colors = colors
    )
}

@Composable
fun AreaChartScreen(values: List<Float>, colors: List<Color>) {
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    val yLabel = "Valores"

    DrawAreaChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        areaColors = colors
    )
}