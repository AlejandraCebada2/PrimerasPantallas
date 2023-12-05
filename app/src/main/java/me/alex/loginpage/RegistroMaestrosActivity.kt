package me.alex.loginpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistroMaestrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_maestros)

        val emailLayout = findViewById<TextInputLayout>(R.id.emailLayout)
        val nombreperfilEmail = findViewById<TextInputEditText>(R.id.nombreperfil)

        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordLayout)
        val passET = findViewById<TextInputEditText>(R.id.passET)

        val confirmPasswordLayout = findViewById<TextInputLayout>(R.id.confirmPasswordLayout)
        val confirmPassEt = findViewById<TextInputEditText>(R.id.confirmPassEt)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        val imageView4 = findViewById<ImageView>(R.id.imageView4)

        button.setOnClickListener {
            // Agrega la lógica del botón según tus necesidades
        }
    }
}
