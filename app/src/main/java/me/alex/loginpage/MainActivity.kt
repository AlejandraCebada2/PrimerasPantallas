package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

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
        loginButton = findViewById(R.id.button)
        registerButton = findViewById(R.id.button2)
        forgotPasswordTextView = findViewById(R.id.textView2)

        loginButton.setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                val intent = Intent(this, InicioAlumnosActivity::class.java)
                startActivity(intent)
            } else {
            }
        }

        registerButton.setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Aquí colocas la lógica para procesar el inicio de sesión

                // Después de procesar el inicio de sesión, puedes redirigir a la pantalla de registro
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
            } else {
                // Muestra un mensaje o realiza alguna acción para indicar que los campos son obligatorios
            }
        }

        // Agregamos un OnClickListener para el TextView de olvidaste la contraseña
        forgotPasswordTextView.setOnClickListener {
            // Inicia la actividad MainActivityRecuperarPassword
            val intent = Intent(this, MainActivityRecuperarPassword::class.java)
            startActivity(intent)
        }
    }
}
