package com.saadeh.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class gasprice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gasprice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edtPrice = findViewById<EditText>(R.id.edt_Price)

        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener() {
            if (edtPrice.text.toString() == ""){
                Snackbar
                    .make(
                        edtPrice,
                        "Preencha o preço.",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
            val intent = Intent(this,carautonomy::class.java)
            intent.putExtra(KEY_FUEL_PRICE,edtPrice.text.toString())
            startActivity(intent)
            }
        }

        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnBack.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}