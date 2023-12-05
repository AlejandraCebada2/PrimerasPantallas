package me.alex.loginpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import me.alex.loginpage.R

class MainActivityRecuperarPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recuperar_password)

        val button3 = findViewById<Button>(R.id.button3)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val nombreperfil = findViewById<TextInputEditText>(R.id.nombreperfil)

        button3.setOnClickListener {

        }
    }
}
