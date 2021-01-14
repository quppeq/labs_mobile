package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hello = findViewById<EditText>(R.id.editTextTextPersonName)
//        hello.setText(Lab2().map { "${it.key} ${it.value}" }.joinToString("\n\r"))
        hello.setText(Lab2_2().map { it }.joinToString ("\n\r"))

    }
}