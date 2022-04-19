package com.hfad.kotlin_final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val words = resources.getStringArray(R.array.wordsList)

        val textDisplay = findViewById<TextView>(R.id.ASD)

        var temp = ""

        for(String in words)
        {
            temp += ", " + String
        }

        textDisplay.text = temp
    }
}