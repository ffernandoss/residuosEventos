package com.example.myapplication.Calendario

import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout

class MainCalendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calendario) // Asegúrate de tener este layout

        val calendarView = findViewById<CalendarView>(R.id.calendarView) // Reemplaza con el ID de tu CalendarView

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Aquí puedes manejar la fecha seleccionada
            val date = "$dayOfMonth/${month + 1}/$year" // Meses van de 0 a 11
            // Por ejemplo, mostrar la fecha en un Toast o TextView
        }
    }
}