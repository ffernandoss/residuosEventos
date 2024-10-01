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

// Actividad secundaria de la aplicación
class SegundaActividad : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establecer el contenido de la actividad usando Jetpack Compose
        setContent {
            MyApplicationTheme {
                BarChartScreen()
            }
        }
    }
}

// Función composable que define la pantalla del gráfico de barras
@Composable
fun BarChartScreen() {
    // Variables para almacenar los valores ingresados por el usuario
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    // Variable para controlar si se deben mostrar los gráficos
    var showCharts by remember { mutableStateOf(false) }
    // Variable para almacenar mensajes de error
    var errorMessage by remember { mutableStateOf<String?>(null) }
    // Variable para almacenar la opción seleccionada en el menú desplegable
    var selectedOption by remember { mutableStateOf("") }
    // Variable para controlar la visibilidad del diálogo de error
    var showDialog by remember { mutableStateOf(false) }

    // Colores para cada función
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

    // Opciones para el menú desplegable
    val options = listOf("Función 1", "Función 2", "Función 3", "Función 4", "Función 5", "Función 6", "Función 7")

    // Crear una columna que llena todo el tamaño de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar un texto con el título
        Text(text = "FUNCION 1", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        // Campo de texto para ingresar el valor 1
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Valor 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Campo de texto para ingresar el valor 2
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Valor 2") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Campo de texto para ingresar el valor 3
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Valor 3") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Botón para mostrar todas las funciones
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
        // Mostrar mensaje de error si existe
        errorMessage?.let {
            Text(text = it, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Menú desplegable para elegir una función
        DropdownMenuButton(options = options, selectedOption = selectedOption) { option ->
            selectedOption = option
            showCharts = false
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Mostrar gráficos según la opción seleccionada
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

    // Mostrar diálogo de error si showDialog es true
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

// Función composable para el menú desplegable
@Composable
fun DropdownMenuButton(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        // Botón para mostrar el menú desplegable
        Button(onClick = { expanded = true }) {
            Text(text = "Elegir gráfico")
        }
        // Menú desplegable
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

// Función composable para la pantalla del gráfico de barras 2
@Composable
fun BarChartScreen2(values: List<Float>, colors: List<Color>) {
    // Etiquetas para el eje X
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    // Etiqueta para el eje Y
    val yLabel = "Valores"

    // Llamar a la función DrawBarChart para dibujar el gráfico de barras
    DrawBarChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        barColors = colors,
        showValues = false
    )
}

// Función composable para la pantalla del gráfico de líneas
@Composable
fun LineChartScreen(values: List<Float>, colors: List<Color>) {
    // Etiquetas para el eje X
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    // Etiqueta para el eje Y
    val yLabel = "Valores"

    // Llamar a la función DrawLineChart para dibujar el gráfico de líneas
    DrawLineChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        lineColors = colors
    )
}

// Función composable para la pantalla del gráfico de pastel
@Composable
fun PieChartScreen(values: List<Float>, colors: List<Color>) {
    // Llamar a la función DrawPieChart para dibujar el gráfico de pastel
    DrawPieChart(
        values = values,
        colors = colors
    )
}

// Función composable para la pantalla del gráfico de dona
@Composable
fun CircleChartScreen(values: List<Float>, colors: List<Color>) {
    // Llamar a la función DrawDonutChart para dibujar el gráfico de dona
    DrawDonutChart(
        values = values,
        colors = colors
    )
}

// Función composable para la pantalla del gráfico de media luna
@Composable
fun HalfCircleChartScreen(values: List<Float>, colors: List<Color>) {
    // Llamar a la función DrawHalfCircleChart para dibujar el gráfico de media luna
    DrawHalfCircleChart(
        values = values,
        colors = colors
    )
}

// Función composable para la pantalla del gráfico de área
@Composable
fun AreaChartScreen(values: List<Float>, colors: List<Color>) {
    // Etiquetas para el eje X
    val xLabels = listOf("valor 1", "valor 2", "valor 3")
    // Etiqueta para el eje Y
    val yLabel = "Valores"

    // Llamar a la función DrawAreaChart para dibujar el gráfico de área
    DrawAreaChart(
        values = values,
        xLabels = xLabels,
        yLabel = yLabel,
        areaColors = colors
    )
}