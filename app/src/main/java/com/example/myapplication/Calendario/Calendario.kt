package com.example.myapplication.Calendario

import android.os.Bundle
import android.view.Gravity
import android.widget.CalendarView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainCalendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear un LinearLayout vertical para contener el CalendarView
        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            gravity = Gravity.CENTER
        }

        // Crear el CalendarView dinámicamente
        val calendarView = CalendarView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // Configurar listener para la selección de fecha
            setOnDateChangeListener { _, year, month, dayOfMonth ->
                val date = "$dayOfMonth/${month + 1}/$year"
                // Aquí puedes manejar la fecha seleccionada (mostrar un Toast, etc.)
            }
        }

        // Agregar el CalendarView al LinearLayout
        linearLayout.addView(calendarView)

        // Establecer el LinearLayout como el contenido de la actividad
        setContentView(linearLayout)
    }

}