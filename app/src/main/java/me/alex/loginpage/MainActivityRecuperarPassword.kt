package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class MainActivityRecuperarPassword : AppCompatActivity() {
    private lateinit var nombrePerfilEditText : TextInputEditText
    private lateinit var button3 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recuperar_password)

        nombrePerfilEditText = findViewById(R.id.nombrePerfilEditText)
        button3 = findViewById(R.id.button3)

        button3.setOnClickListener{
            validacion()
        }
    }

    private fun validacion() {
        val correo = nombrePerfilEditText.text.toString()
        if(correo.isNotEmpty()){
            enviarcorreo(correo)
        }
    }

    private fun enviarcorreo(correo: String) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(correo).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
              showAlert2()
            }
        }
    }
    private fun showAlert2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Correo invalido")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
