package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var forgotPasswordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.editTextText2)
        passwordEditText = findViewById(R.id.editText2)
        loginButton = findViewById(R.id.IniciaSe)
        registerButton = findViewById(R.id.Registrarse)
        forgotPasswordTextView = findViewById(R.id.noPass)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, InicioAlumnosActivity::class.java)
                startActivity(intent)
            } else {
                showToast("Por favor, completa todos los campos, son obligatorios.")
            }
        }

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
            } else {
                showToast("Por favor, completa todos los campos.")
            }
        }

        forgotPasswordTextView.setOnClickListener {
            val intent = Intent(this, MainActivityRecuperarPassword::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
