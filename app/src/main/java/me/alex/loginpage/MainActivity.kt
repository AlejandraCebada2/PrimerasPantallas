package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var CorreoElectronico: EditText
    private lateinit var Contrasenia: EditText
    private lateinit var IniciaSe: Button
    private lateinit var Registrarse: Button
    private lateinit var noPass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CorreoElectronico = findViewById(R.id.CorreoElectronico)
        Contrasenia = findViewById(R.id.Contrasenia)

        IniciaSe = findViewById(R.id.IniciaSe)
        Registrarse = findViewById(R.id.Registrarse)
        noPass = findViewById(R.id.noPass)

        IniciaSe.setOnClickListener {
            if (CorreoElectronico.text.isNotEmpty() && Contrasenia.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(CorreoElectronico.text.toString(),
                    Contrasenia.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        iniciarSesion (it.result?.user?.email ?: "")
                    } else {
                        error()
                    }
                }
            } else {
                error()
            }
        }

        Registrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        noPass.setOnClickListener {
            val intent = Intent(this, MainActivityRecuperarPassword::class.java)
            startActivity(intent)
        }
    }

    private fun iniciarSesion(email: String){
        val intent = Intent (this, InicioAlumnosActivity::class.java).apply {
            putExtra("email", email)
        }
        startActivity(intent)
    }

    private fun error() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario o contraseña incorrecto")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}
