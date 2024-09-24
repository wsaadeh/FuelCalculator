package com.saadeh.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale

const val KEY_PR = "Result.Key_Pr"
const val KEY_AT = "Result.Key_At"
const val KEY_DT = "Result.Key_Dt"

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPreco = intent.getStringExtra(KEY_PR)
        val edtCons = intent.getStringExtra(KEY_AT)
        val edtDist = intent.getStringExtra(KEY_DT)

        val tvPreco = findViewById<TextView>(R.id.tv_price)
        val tvCons = findViewById<TextView>(R.id.tv_autonomy)
        val tvDist = findViewById<TextView>(R.id.tv_distance)

        tvPreco.text =  edtPreco
        tvCons.text = edtCons
        tvDist.text = edtDist

        println("Preco = " + edtPreco.toString() )
        println("Consumo = " + edtCons.toString() )
        println("Distancia = " + edtDist.toString())

        var vPreco: Float = tvPreco.text.toString().toFloat()
        var vCons: Float = tvCons.text.toString().toFloat()
        var vDist: Float = tvDist.text.toString().toFloat()

        val lvRes: Float = (vDist / vCons ) * vPreco


        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = NumberFormat.getCurrencyInstance(Locale("pt","BR")).format(lvRes)



        val btnNew = findViewById<Button>(R.id.btnNew)

        btnNew.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}