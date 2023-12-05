package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import me.alex.loginpage.R

class MainActivityPaginaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pagina_principal)

        val imageView14 = findViewById<ImageView>(R.id.imageView14)

        imageView14.setOnClickListener {
            // Crea un Intent para iniciar la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)

            // Inicia la nueva actividad
            startActivity(intent)
        }
    }
}
