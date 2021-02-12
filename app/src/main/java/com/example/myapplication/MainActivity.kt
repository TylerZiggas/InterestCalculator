package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.TextureView
import android.widget.*

// classes begin with uppercase
// var should be camel case

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Mortgage Calculator"
        var yearChoice: Spinner = findViewById(R.id.editYear)
        //val adapter = ArrayAdapter.createFromResource(
        //       this,
         //       R.array.editYear,
         //       android.R.layout.simple_spinner_item
        //)
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
       // yearChoice.adapter = adapter
       // yearChoice.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }
}