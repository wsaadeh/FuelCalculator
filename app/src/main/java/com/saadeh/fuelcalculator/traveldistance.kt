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

const val KEY_PRICE = "traveldistance.KEY_Price"
const val KEY_FUEL_AUT = "traveldistance.KEY_Aut"

class traveldistance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_traveldistance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrice = intent.getStringExtra(KEY_PRICE)
        val edtCons = intent.getStringExtra(KEY_FUEL_AUT)


        val edtDistancia = findViewById<EditText>(R.id.edt_dist)

        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener(){
            if (edtDistancia.text.toString() == ""){
                Snackbar
                    .make(
                        edtDistancia,
                        "Preencha o distância.",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
            val intent = Intent(this, result::class.java)
            intent.putExtra(KEY_PR,edtPrice)
            intent.putExtra(KEY_AT,edtCons)
            intent.putExtra(KEY_DT,edtDistancia.text.toString())
            startActivity(intent)
            }
        }

        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnBack.setOnClickListener(){
            val intent = Intent(this,carautonomy::class.java)
            intent.putExtra(KEY_FUEL_PRICE,edtPrice.toString())
            startActivity(intent)
        }
    }
}