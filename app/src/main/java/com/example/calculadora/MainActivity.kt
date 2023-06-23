package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var listaDeNumeros = mutableListOf<Double>()
    private var acumulador : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.botonSuma.setOnClickListener {

            listaDeNumeros.add(binding.editTextNumeros.text.toString().toDouble())
            binding.editTextNumeros.setText("")

        }

        binding.botonResta.setOnClickListener {

            sumar()
        }

        binding.botonMultiplicacion.setOnClickListener {

        }
    }


   fun sumar(){

       for (numero in listaDeNumeros) {
            acumulador+= numero
       }

       binding.editTextNumeros.setText(acumulador.toString())
       listaDeNumeros.clear()

    }
/*
    fun restar() : Double {

    }

    fun multiplicar() : Double  {

    }


 */
}