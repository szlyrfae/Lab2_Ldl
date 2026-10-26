package com.athirah.lab2_ldl

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvDisplayName)
        val tvAge = findViewById<TextView>(R.id.tvDisplayAge)

        val dataName = intent.getStringExtra("EXTRA_NAME") ?: "No name input"
        val dataAge = intent.getStringExtra("EXTRA_AGE") ?: "No age input"

        tvName.text = "Name: $dataName"
        tvAge.text = "Age: $dataAge"
    }
}