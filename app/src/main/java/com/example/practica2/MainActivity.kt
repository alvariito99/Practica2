package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        btnAnswer.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)
            val name = etName.text.toString()

            if (name.isEmpty()) {
                // Mostrar mensaje de error si no se ingresa el nombre
                Toast.makeText(this, "Debe introducir un nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Pasar a la siguiente actividad con el nombre
                goToElection(name)
            }
        }
        Log.d("Felix", "main")
    }

    private fun goToElection(name: String) {
        val intent = Intent(this@MainActivity, EleccionActivity::class.java)
        intent.putExtra("NAME", name)
        startActivity(intent)
    }
}
