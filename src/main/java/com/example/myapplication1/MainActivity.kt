package com.example.myapplication1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variables para almacenar los valores
    private var currentNumber: String = ""
    private var result: Double = 0.0
    private var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los TextViews y Buttons
        val textViewResult = findViewById<TextView>(R.id.textView)
        val textViewInput = findViewById<TextView>(R.id.textView2)

        // Numeros
        val button0 = findViewById<Button>(R.id.button14)
        val button1 = findViewById<Button>(R.id.button10)
        val button2 = findViewById<Button>(R.id.button11)
        val button3 = findViewById<Button>(R.id.button12)
        val button4 = findViewById<Button>(R.id.button6)
        val button5 = findViewById<Button>(R.id.button8)
        val button6 = findViewById<Button>(R.id.button7)
        val button7 = findViewById<Button>(R.id.button2)
        val button8 = findViewById<Button>(R.id.button3)
        val button9 = findViewById<Button>(R.id.button4)

        // Operadores
        val buttonAdd = findViewById<Button>(R.id.button5)
        val buttonEquals = findViewById<Button>(R.id.button9)

        // Setea los números
        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                currentNumber += index.toString()
                textViewInput.text = currentNumber
            }
        }

        // Suma
        buttonAdd.setOnClickListener {
            operation = "+"
            result = currentNumber.toDoubleOrNull() ?: 0.0
            currentNumber = ""
            textViewInput.text = ""
        }

        // Igual
        buttonEquals.setOnClickListener {
            val secondNumber = currentNumber.toDoubleOrNull() ?: 0.0
            if (operation == "+") {
                result += secondNumber
            }
            textViewResult.text = result.toString()
            currentNumber = ""
        }
    }
}
