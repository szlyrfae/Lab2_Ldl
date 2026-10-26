package com.athirah.lab2_ldl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnGoogle = findViewById<Button>(R.id.btnGoogle)
        val btnShare = findViewById<Button>(R.id.btnShare)

        btnProfile.setOnClickListener {
            val name = edtName.text.toString().trim()
            val age = edtAge.text.toString().trim()

            if (name.isEmpty() && age.isEmpty()){
                Toast.makeText(this,R.string.error_empty, Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("EXTRA_NAME",name)
                intent.putExtra("EXTRA_AGE", age)
                startActivity(intent)
            }
        }

        btnGoogle.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kirakira.sekutu.org"))

            startActivity(webIntent)
        }

        btnShare.setOnClickListener {
            val textString = "Name: ${edtName.text}, Age: ${edtAge.text}"
            val shareInt = Intent(Intent.ACTION_SEND).apply{
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textString)
            }
            startActivity(Intent.createChooser(shareInt,"Shared Through....."))
        }
    }
}