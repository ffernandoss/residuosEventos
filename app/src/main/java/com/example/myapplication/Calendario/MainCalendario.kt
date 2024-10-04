package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.widget.CalendarView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
class MainCalendario : AppCompatActivity() {
    private val dateTextMap = HashMap<String, String>()

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
        }

        // Crear un TextView para mostrar el texto de la fecha seleccionada
        val textView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            gravity = Gravity.CENTER
        }

        // Configurar listener para la selección de fecha
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"

            // Crear un EditText para ingresar el texto
            val editText = EditText(this).apply {
                hint = "Ingrese texto aquí"
                setText(dateTextMap[date]) // Mostrar el texto guardado si existe
            }

            // Crear un AlertDialog para mostrar el EditText
            val dialog = AlertDialog.Builder(this)
                .setTitle("Ingrese texto para la fecha: $date")
                .setView(editText)
                .setPositiveButton("Aceptar") { _, _ ->
                    val text = editText.text.toString()
                    dateTextMap[date] = text
                    textView.text = "Fecha: $date\nTexto: $text"
                    Toast.makeText(this, "Texto guardado para la fecha: $date", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .create()

            dialog.show()
        }

        // Crear un Button para ir al mapa
        val button = Button(this).apply {
            text = "Ir al Mapa"
            setOnClickListener {
                val intent = Intent(this@MainCalendario, MapaResiduos::class.java)
                startActivity(intent)
            }
        }

        // Agregar el CalendarView, el TextView y el Button al LinearLayout
        linearLayout.addView(calendarView)
        linearLayout.addView(textView)
        linearLayout.addView(button)

        // Establecer el LinearLayout como el contenido de la actividad
        setContentView(linearLayout)
    }
}