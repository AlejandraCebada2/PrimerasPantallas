package me.alex.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val textView6 = findViewById<TextView>(R.id.textView6)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)

        button6.setOnClickListener {
                val intent = Intent(this, RegistroMaestrosActivity::class.java)
                startActivity(intent)
        }


        button7.setOnClickListener {
            val intent = Intent(this, RegistroAlumnosActivity::class.java)
            startActivity(intent)
        }
    }
}
