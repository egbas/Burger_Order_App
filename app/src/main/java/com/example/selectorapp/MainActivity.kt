package com.example.selectorapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
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

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        val cbOnion = findViewById<CheckBox>(R.id.cbOnion)
        val cbPepperoni = findViewById<CheckBox>(R.id.cbPepperoni)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnOrder.setOnClickListener {
            Toast.makeText(this, "Hooray! I just learned to make TOASTS", Toast.LENGTH_LONG).show()
            val rbtnMeat = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(rbtnMeat)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val pepperoni = cbPepperoni.isChecked
            val resultString = "You have placed an order for: \n" + "${meat.text} burger\nand the following toppings:" +
                    (if(cheese) "\nCheese" else "") +
                    (if(onion) "\nOnion" else "") +
                    (if(pepperoni) "\nPepperoni" else "")

            tvResult.text = resultString
        }

    }
}