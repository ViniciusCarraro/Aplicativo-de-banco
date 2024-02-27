package com.example.aplicativodebanco

import android.app.Activity
import android.content.Intent
import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MostrarPixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pix)
        setSupportActionBar(findViewById(R.id.tooPix))
       val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btenviar = findViewById<Button>(R.id.btnEnviar)
        val edtchave = findViewById<EditText>(R.id.ChavePix)
        btenviar.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.ValorPix)
            val nvalor = valorPix.text.toString().toDouble()
            if(nsaldo<nvalor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }

            if(nsaldo>nvalor) {
                Toast.makeText(this, "Pix realizado com sucesso",Toast.LENGTH_SHORT).show()
            }
            else {
                nsaldo += nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtchave.setText("".toString())
            finish()
        }
        }
    }
