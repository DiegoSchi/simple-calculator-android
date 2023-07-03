package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        //Boton Suma
        binding.botonSuma.setOnClickListener {

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

            if(!binding.editTextNumeros.text.toString().equals("")) {
                //TODO
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        //Boton Multiplicación
        binding.botonMultiplicacion.setOnClickListener {
            if(!binding.editTextNumeros.text.toString().equals("")) {
                //TODO
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

            val res = sumar()

            binding.editTextNumeros.setText(res.toString())
            listaDeNumeros.clear()
            acumulador = 0.0
        }
    }


   fun sumar() : Double{

       for (numero in listaDeNumeros)  {
            acumulador+= numero
       }

       return acumulador
    }
/*
    fun restar() : Double {

    }

    fun multiplicar() : Double  {

    }


 */
}