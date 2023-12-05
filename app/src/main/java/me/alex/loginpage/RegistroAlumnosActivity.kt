package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroAlumnosActivity : AppCompatActivity() {

    private lateinit var nombrePerfilEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumnos)

        nombrePerfilEditText = findViewById(R.id.nombreperfil)
        emailEditText = findViewById(R.id.emailLayout)
        passwordEditText = findViewById(R.id.passET)
        confirmPasswordEditText = findViewById(R.id.confirmPassEt)
        registerButton = findViewById(R.id.button)
        loginTextView = findViewById(R.id.textView)

        registerButton.setOnClickListener {

            val nombrePerfil = nombrePerfilEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (nombrePerfil.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {

                val intent = Intent(this, InicioAlumnosActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        loginTextView.setOnClickListener {
            // Agrega la lógica para redirigir al usuario a la pantalla de inicio de sesión
            // Por ejemplo, puedes abrir la actividad de inicio de sesión
        }
    }
}
