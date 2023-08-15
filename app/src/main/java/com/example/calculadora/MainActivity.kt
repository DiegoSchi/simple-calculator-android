package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding : ActivityMainBinding
    //Variables globales
    private var listaDeNumeros = mutableListOf<Double>()
    private var acumulador : Double = 0.0
    private var id : String = "DEFAULT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Boton Suma
        binding.botonSuma.setOnClickListener {

            id = "SUMA"
            if(!binding.editTextNumeros.text.toString().equals("")) {
                listaDeNumeros.add(binding.editTextNumeros.text.toString().toDouble())
                binding.editTextNumeros.setText("")
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        //Boton Resta
        binding.botonResta.setOnClickListener {
            id = "RESTA"
            if(!binding.editTextNumeros.text.toString().equals("")) {
                listaDeNumeros.add(binding.editTextNumeros.text.toString().toDouble())
                binding.editTextNumeros.setText("")
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        //Boton Multiplicación
        binding.botonMultiplicacion.setOnClickListener {
            id = "MULTIPLICACION"
            if(!binding.editTextNumeros.text.toString().equals("")) {
                listaDeNumeros.add(binding.editTextNumeros.text.toString().toDouble())
                binding.editTextNumeros.setText("")
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        //Boton Limpiar
        binding.btnDelete.setOnClickListener {

            binding.editTextNumeros.setText("")
            listaDeNumeros.clear()
            acumulador = 0.0
        }
        //Boton Resultado
        binding.btnResultado.setOnClickListener {

            var res = 0.0

            when(id) {
                "SUMA" -> res = sumar()
                "RESTA" -> res = restar()
                "MULTIPLICACION" -> res = multiplicar()
            }

            binding.editTextNumeros.setText(res.toString())
            listaDeNumeros.clear()
            acumulador = 0.0

        }
    }


   private fun sumar() : Double{

       for (numero in listaDeNumeros)  {
            acumulador+= numero
       }

       return acumulador
    }

    private fun restar() : Double {

        for(numero in listaDeNumeros) {
            acumulador-= numero
        }
        return acumulador
    }

    private fun multiplicar() : Double  {

        for(numero in listaDeNumeros) {
            acumulador*= numero
        }

        return acumulador

    }
}