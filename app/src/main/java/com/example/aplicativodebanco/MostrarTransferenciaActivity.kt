package com.example.aplicativodebanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarTransferenciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_transferencia)
        setSupportActionBar(findViewById(R.id.tootransferir))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val transferir = findViewById<Button>(R.id.bttransferir)
        val transf = findViewById<EditText>(R.id.valortransf)
        transferir.setOnClickListener {
            val data = Intent()
            val transf = findViewById<EditText>(R.id.valortransf)
            val nvalor = transf.text.toString().toDouble()
            if(nsaldo<nvalor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                nsaldo -= nvalor
            }

            if(nsaldo>nvalor) {
                Toast.makeText(
                    this, "Transferência realizada com sucesso", Toast.LENGTH_SHORT).show()
            }
            else {
                nsaldo += nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            transf.setText("".toString())
            finish()
        }
    }
    }
