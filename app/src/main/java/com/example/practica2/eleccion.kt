package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EleccionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eleccion)

        val nombre = intent.getStringExtra("NAME")
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        tvBienvenida.text = " Sir $nombre, es el momento que tomes una eleccion..."

        val cbRaenira = findViewById<CheckBox>(R.id.cbRaenira)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnHincarRodilla = findViewById<Button>(R.id.btnHincarRodilla)

        val updateMessage = {
            when {
                cbRaenira.isChecked && cbAegon.isChecked -> tvResultado.text =
                    getString(R.string.final_message_dual)

                cbRaenira.isChecked -> tvResultado.text = getString(R.string.final_message_raenira)
                cbAegon.isChecked -> tvResultado.text = getString(R.string.final_message_aegon)
                else -> tvResultado.text = getString(R.string.final_message_no_choice)
            }
        }

        cbRaenira.setOnCheckedChangeListener { _, _ -> updateMessage() }
        cbAegon.setOnCheckedChangeListener { _, _ -> updateMessage() }

        btnHincarRodilla.setOnClickListener {
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("SELECTION", tvResultado.text.toString())
            startActivity(intent)
        }

    }
}