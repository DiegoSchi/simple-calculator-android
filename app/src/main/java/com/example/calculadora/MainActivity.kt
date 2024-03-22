package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.data.Operations
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityMainBinding

    //Variables globales
    private var acumulador: Double = 0.0
    private var id: Operations = Operations.DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Boton Suma
        binding.botonSuma.setOnClickListener {

            id = Operations.SUMA
            if (binding.editTextNumeros.text.toString() != "") {
                val numeroActual = binding.editTextNumeros.text.toString().toDouble()
                sumar(numeroActual)
                binding.editTextNumeros.setText("")
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        //Boton Resta
        binding.botonResta.setOnClickListener {
            id = Operations.RESTA
            if (binding.editTextNumeros.text.toString() != "") {
                val numeroActual = binding.editTextNumeros.text.toString().toDouble()
                restar(numeroActual)
                binding.editTextNumeros.setText("")
            } else {
                Toast.makeText(applicationContext, "INTRODUCE UN NÚMERO", Toast.LENGTH_SHORT).show()
            }

        }
        //Boton Multiplicación
        binding.botonMultiplicacion.setOnClickListener {
            id = Operations.MULTIPLICACION
            if (binding.editTextNumeros.text.toString() != "") {
                val numActual = binding.editTextNumeros.text.toString().toDouble()
                multiplicar(numActual)
                binding.editTextNumeros.setText("")
            } else {
                val toast = Toast.makeText(this, "INTRODUCE UN NUMERO", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        //Boton Limpiar
        binding.btnDelete.setOnClickListener {
            id = Operations.DEFAULT
            acumulador = 0.0
            binding.editTextNumeros.setText("")
        }
        //Boton Resultado
        binding.btnResultado.setOnClickListener {

            val res: Double

            when (id) {
                Operations.SUMA -> {
                    if (binding.editTextNumeros.text.toString() != "") {
                        res = sumar(binding.editTextNumeros.text.toString().toDouble())
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    } else {
                        res = sumar(ZERO)
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    }
                }

                Operations.RESTA -> {
                    if (binding.editTextNumeros.text.toString() != "") {
                        res = restar(binding.editTextNumeros.text.toString().toDouble())
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    } else {
                        res = restar(ZERO)
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    }
                }

                Operations.MULTIPLICACION -> {
                    if (binding.editTextNumeros.text.toString() != "") {
                        res = multiplicar(binding.editTextNumeros.text.toString().toDouble())
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    } else {
                        res = multiplicar(ZERO)
                        binding.editTextNumeros.setText(res.toString())
                        acumulador = 0.0
                    }
                }

                else -> Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun sumar(numActual: Double): Double {

        acumulador += numActual

        return acumulador
    }

    private fun restar(numActual: Double): Double {

        if (acumulador == 0.0) {
            acumulador = abs(acumulador - numActual)
        } else {
            acumulador -= numActual
        }

        return acumulador
    }

    private fun multiplicar(numActual: Double): Double {
        if (acumulador == 0.0) {
            acumulador = numActual * ONE
        } else {
            acumulador *= numActual
        }

        return acumulador
    }

    companion object {
        private const val ZERO: Double = 0.0
        private const val ONE: Double = 1.0
    }
}