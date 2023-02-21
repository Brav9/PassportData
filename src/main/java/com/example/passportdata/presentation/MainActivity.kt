package com.example.passportdata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.passportdata.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created!")
        viewModel = ViewModelProvider(
            this, MainViewModelFactory(this)
        )[MainViewModel::class.java]

        val tvInfoPassport = findViewById<TextView>(R.id.tvInfoPassport)


        val etNamePassport = findViewById<EditText>(R.id.etNamePassport)
        val etSurnamePassport = findViewById<EditText>(R.id.etSurnamePassport)
        val etCodePassport = findViewById<EditText>(R.id.etCodePassport)
        val etPassportNo = findViewById<EditText>(R.id.etPassportNo)

        val btnSaveInfo = findViewById<Button>(R.id.btnSaveInfo)
        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)

        viewModel.resultLive.observe(this) {
            tvInfoPassport.text = it.toString()
        }


        btnSaveInfo.setOnClickListener {
            val namePassport = etNamePassport.text.toString()
            val surnamePassport = etSurnamePassport.text.toString()
            val codePassport = etCodePassport.text.toString()
            val passportNo = etPassportNo.text.toString()
            viewModel.save(namePassport, surnamePassport, codePassport, passportNo)
        }

        btnGetInfo.setOnClickListener {
            viewModel.load()
        }
    }
}