package com.example.passportdata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.passportdata.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvPassport = findViewById<TextView>(R.id.tvPassport)
        val tvSurnamePassport = findViewById<TextView>(R.id.tvSurname)
        val tvCodePassport = findViewById<TextView>(R.id.tvCodePassport)
        val tvPassportNo = findViewById<TextView>(R.id.tvPassportNo)

        val etNamePassport = findViewById<EditText>(R.id.etNamePassport)
        val etSurnamePassport = findViewById<EditText>(R.id.etSurnamePassport)
        val etCodePassport = findViewById<EditText>(R.id.etCodePassport)
        val etPassportNo = findViewById<EditText>(R.id.etPassportNo)

        val btnSaveInfo = findViewById<Button>(R.id.btnSaveInfo)
        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)

        btnSaveInfo.setOnClickListener {

        }

        btnGetInfo.setOnClickListener {

        }

    }
}