package com.angelcorrea.formulariocontactoactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val nombreEditText = findViewById<EditText>(R.id.editTextText)
        val telefonoEditText = findViewById<EditText>(R.id.editTextText2)
        val mensajeEditText = findViewById<EditText>(R.id.editTextText3)
        val enviarButton = findViewById<Button>(R.id.button)
        enviarButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val telefono = telefonoEditText.text.toString()
            val mensaje = mensajeEditText.text.toString()

            if (nombre.isEmpty() || telefono.isEmpty() || mensaje.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                val datosUsuario = """
                    Nombre: $nombre
                    Teléfono: $telefono
                    Mensaje: $mensaje
                """.trimIndent()
                Toast.makeText(this, datosUsuario, Toast.LENGTH_LONG).show()
            }
        }
    }
}