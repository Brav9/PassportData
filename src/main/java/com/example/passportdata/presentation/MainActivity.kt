package com.example.passportdata.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.passportdata.R
import com.example.passportdata.data.repository.InfoRepositoryImpl
import com.example.passportdata.data.storage.SharedPrefs.SharedPrefsInfoStorage
import com.example.passportdata.domain.models.InfoPassport
import com.example.passportdata.domain.usecase.GetInfoPassportUseCase
import com.example.passportdata.domain.usecase.SaveInfoPassportUseCase

class MainActivity : AppCompatActivity() {

    private val infoRepository by lazy {
        InfoRepositoryImpl(
            infoStorage = SharedPrefsInfoStorage(context = applicationContext)
        )
    }

    private val saveInfoPassportUseCase by lazy {
        SaveInfoPassportUseCase(infoRepository = infoRepository)
    }

    private val getInfoPassportUseCase by lazy {
        GetInfoPassportUseCase(infoRepository = infoRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfoPassportName = findViewById<TextView>(R.id.tvInfoPassportName)
        val tvInfoPassportSurname = findViewById<TextView>(R.id.tvInfoPassportSurname)
        val tvInfoPassportCode = findViewById<TextView>(R.id.tvInfoPassportCode)
        val tvInfoPassportNo = findViewById<TextView>(R.id.tvInfoPassportNo)

        val etNamePassport = findViewById<EditText>(R.id.etNamePassport)
        val etSurnamePassport = findViewById<EditText>(R.id.etSurnamePassport)
        val etCodePassport = findViewById<EditText>(R.id.etCodePassport)
        val etPassportNo = findViewById<EditText>(R.id.etPassportNo)

        val btnSaveInfo = findViewById<Button>(R.id.btnSaveInfo)
        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)

        btnSaveInfo.setOnClickListener {
            val namePassport = etNamePassport.text.toString()
            val surnamePassport = etSurnamePassport.text.toString()
            val codePassport = etCodePassport.text.toString()
            val passportNo = etPassportNo.text.toString()

            val infoParams = InfoPassport(
                namePassport = namePassport,
                surnamePassport = surnamePassport,
                codePassport = codePassport,
                passportNo = passportNo
            )

            val result: Boolean = saveInfoPassportUseCase.execute(infoPassport = infoParams)
            tvInfoPassportName.text = result.toString()
        }

        btnGetInfo.setOnClickListener {
            val infoPassport: InfoPassport = getInfoPassportUseCase.execute()
            tvInfoPassportName.text = infoPassport.namePassport
            tvInfoPassportSurname.text = infoPassport.surnamePassport
            tvInfoPassportCode.text = infoPassport.codePassport
            tvInfoPassportNo.text = infoPassport.passportNo
        }

    }
}