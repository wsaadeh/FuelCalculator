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

const val KEY_FUEL_PRICE = "ConsumoCarro.KEY_Price"

class carautonomy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carautonomy)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPreco = intent.getStringExtra(KEY_FUEL_PRICE)
        val edtConsumo = findViewById<EditText>(R.id.edt_car)


        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener(){
            if (edtConsumo.text.toString() == ""){
                Snackbar
                    .make(
                        edtConsumo,
                        "Preencha o consumo.",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
            val intent = Intent(this,traveldistance::class.java)
            intent.putExtra(KEY_PRICE, edtPreco)
            intent.putExtra(KEY_FUEL_AUT,edtConsumo.text.toString())
            startActivity(intent)
            }
        }

        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnBack.setOnClickListener(){
            val intent = Intent(this, gasprice::class.java)
            startActivity(intent)
        }
    }
}