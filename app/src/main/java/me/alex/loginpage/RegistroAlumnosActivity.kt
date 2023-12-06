package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroAlumnosActivity : AppCompatActivity() {

    private lateinit var nombrePerfilEditText: TextInputEditText
    private lateinit var emailperfil: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var confirmPasswordEditText: TextInputEditText
    private lateinit var registerButton: AppCompatButton
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumnos)

        nombrePerfilEditText = findViewById(R.id.nombrePerfilEditText)
        emailperfil = findViewById(R.id.emailperfil)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        registerButton = findViewById(R.id.registerButton)

        loginTextView = findViewById(R.id.loginTextView)

        registerButton.setOnClickListener {
            if (nombrePerfilEditText.text.toString().isNotEmpty() && emailperfil.text.toString().isNotEmpty() && passwordEditText.text.toString().isNotEmpty() && confirmPasswordEditText.text.toString().isNotEmpty()) {
                if(passwordEditText.text.toString().equals(confirmPasswordEditText.text.toString())){
                    if (passwordEditText.text.toString().length >= 6){
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword (emailperfil.text.toString(),
                            passwordEditText.text.toString()).addOnCompleteListener {
                            if (it.isSuccessful) {

                                val map: MutableMap<String, Any> = HashMap()
                                map["nombre"] = nombrePerfilEditText.text.toString()
                                map["correo"] = emailperfil.text.toString()
                                map["contraseña"] = passwordEditText.text.toString()


                                val id: String? = FirebaseAuth.getInstance().currentUser?.uid
                                FirebaseDatabase.getInstance().getReference().child("Alumnos").child(id.toString()).setValue(map).addOnCompleteListener{
                                    if (it.isSuccessful) {
                                        val intent = Intent(this, InicioAlumnosActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                            } else {
                                showAlert()
                            }
                        }
                    } else {
                        showAlert2()
                    }
                }else{
                    showAlert3()
                }
            }else{
                showAlert4()
            }
        }

        loginTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlert2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("La contraseña debe tener al menos 6 caracteres")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlert3() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Las contraseñas no coinciden")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlert4() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Debes completar todos los datos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
