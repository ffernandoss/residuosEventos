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
    var showChart by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty()) {
                errorMessage = "Todos los campos deben estar completos."
                showErrorDialog = true
            } else if (!value1.all { it.isDigit() } || !value2.all { it.isDigit() } || !value3.all { it.isDigit() }) {
                errorMessage = "Los campos deben contener solo números."
                showErrorDialog = true
            } else {
                showChart = true
            }
        }) {
            Text("Mostrar Gráficas")
        }
    }

    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            confirmButton = {
                Button(onClick = { showErrorDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Error") },
            text = { Text(errorMessage) }
        )
    }
}