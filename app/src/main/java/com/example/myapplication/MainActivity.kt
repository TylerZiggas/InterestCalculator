package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// classes begin with uppercase
// var should be camel case

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        val editAPR = findViewById<EditText>(R.id.editAPR)
        val editEscrow = findViewById<EditText>(R.id.editEscrow)
        val editLoan = findViewById<EditText>(R.id.editLoan)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        calculateButton.setOnClickListener {
            println("Clicked!")
        }

        resetButton.setOnClickListener {
        }
    }
}