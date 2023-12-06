package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroMaestrosActivity : AppCompatActivity() {
    private lateinit var nombrePerfil: TextInputEditText
    private lateinit var correoEditText: TextInputEditText
    private lateinit var passwordEdit: TextInputEditText
    private lateinit var confirmPasswordEdit: TextInputEditText
    private lateinit var curpEditText: TextInputEditText
    private lateinit var register: AppCompatButton
    private lateinit var loginText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_maestros)

        nombrePerfil = findViewById(R.id.nombrePerfil)
        correoEditText = findViewById(R.id.correoEditText)
        passwordEdit = findViewById(R.id.passwordEdit)
        confirmPasswordEdit = findViewById(R.id.confirmPasswordEdit)
        curpEditText = findViewById(R.id.curpEditText)

        register = findViewById(R.id.register)

        loginText = findViewById(R.id.loginText)

        register.setOnClickListener {
            if (nombrePerfil.text.toString().isNotEmpty() && correoEditText.text.toString().isNotEmpty() && passwordEdit.text.toString().isNotEmpty() && confirmPasswordEdit.text.toString().isNotEmpty() && curpEditText.text.toString().isNotEmpty()) {
                if(passwordEdit.text.toString().equals(confirmPasswordEdit.text.toString())){
                    if (passwordEdit.text.toString().length >= 6){
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword (correoEditText.text.toString(),
                            passwordEdit.text.toString()).addOnCompleteListener {
                            if (it.isSuccessful) {

                                val map: MutableMap<String, Any> = HashMap()
                                map["nombre"] = nombrePerfil.text.toString()
                                map["curp"] = curpEditText.text.toString()
                                map["correo"] = correoEditText.text.toString()
                                map["contraseña"] = passwordEdit.text.toString()

                                val id: String? = FirebaseAuth.getInstance().currentUser?.uid
                                FirebaseDatabase.getInstance().getReference().child("Maestros").child(id.toString()).setValue(map).addOnCompleteListener{
                                    if (it.isSuccessful) {
                                        val intent = Intent(this, InicioAlumnosActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                            } else {
                                showAlert()
                            }
                        }
                    }else{
                        showAlert2()
                    }
                }else{
                    showAlert3()
                }
            }else{
                showAlert4()
            }
        }

        loginText.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showHome(email: String){
        val intent = Intent (this, MainActivity::class.java).apply {
            putExtra("email", email)
        }
        startActivity(intent)
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
