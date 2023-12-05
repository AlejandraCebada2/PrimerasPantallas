package me.alex.loginpage

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.SearchView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.alex.loginpage.R
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity4 : AppCompatActivity() {

    private lateinit var constraintLayout: androidx.constraintlayout.widget.ConstraintLayout
    private lateinit var imageView20: ImageView
    private lateinit var textView17: TextView
    private lateinit var textView18: TextView
    private lateinit var ratingBar: RatingBar

    private lateinit var constraintLayout2: androidx.constraintlayout.widget.ConstraintLayout
    private lateinit var textView20: TextView
    private lateinit var textView19: TextView
    private lateinit var imageView21: ImageView
    private lateinit var ratingBar2: RatingBar

    private lateinit var constraintLayout3: androidx.constraintlayout.widget.ConstraintLayout
    private lateinit var ratingBar3: RatingBar
    private lateinit var textView22: TextView
    private lateinit var textView21: TextView
    private lateinit var imageView22: ImageView

    private lateinit var constraintLayout4: androidx.constraintlayout.widget.ConstraintLayout
    private lateinit var ratingBar4: RatingBar
    private lateinit var textView24: TextView
    private lateinit var textView23: TextView
    private lateinit var imageView24: ImageView

    private lateinit var searchView: SearchView
    private lateinit var spinner4: Spinner
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        constraintLayout = findViewById(R.id.constraintLayout)
        imageView20 = findViewById(R.id.imageView20)
        textView17 = findViewById(R.id.textView17)
        textView18 = findViewById(R.id.textView18)
        ratingBar = findViewById(R.id.ratingBar)

        constraintLayout2 = findViewById(R.id.constraintLayout2)
        textView20 = findViewById(R.id.textView20)
        textView19 = findViewById(R.id.textView19)
        imageView21 = findViewById(R.id.imageView21)
        ratingBar2 = findViewById(R.id.ratingBar2)

        constraintLayout3 = findViewById(R.id.constraintLayout3)
        ratingBar3 = findViewById(R.id.ratingBar3)
        textView22 = findViewById(R.id.textView22)
        textView21 = findViewById(R.id.textView21)
        imageView22 = findViewById(R.id.imageView22)

        constraintLayout4 = findViewById(R.id.constraintLayout4)
        ratingBar4 = findViewById(R.id.ratingBar4)
        textView24 = findViewById(R.id.textView24)
        textView23 = findViewById(R.id.textView23)
        imageView24 = findViewById(R.id.imageView24)

        searchView = findViewById(R.id.searchView)
        spinner4 = findViewById(R.id.spinner4)
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)
    }
}
