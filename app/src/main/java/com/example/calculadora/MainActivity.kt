package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tituloActivity : TextView = findViewById(R.id.textViewTitulo)
        val numerosCaja : EditText = findViewById(R.id.editTextNumeros)
        val btnSumar : Button = findViewById(R.id.botonSuma)
        val btnRestar : Button = findViewById(R.id.botonResta)
        val btnMultiplicar : Button = findViewById(R.id.botonMultiplicacion)
    }


/*
    fun sumar() : Double {

    }

    fun restar() : Double {

    }

    fun multiplicar() : Double  {

    }


 */
}