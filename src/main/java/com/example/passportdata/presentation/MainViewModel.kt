package com.example.passportdata.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.passportdata.domain.models.InfoPassport
import com.example.passportdata.domain.usecase.GetInfoPassportUseCase
import com.example.passportdata.domain.usecase.SaveInfoPassportUseCase

class MainViewModel(
    private val getInfoPassportUseCase: GetInfoPassportUseCase,
    private val saveInfoPassportUseCase: SaveInfoPassportUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<List<String>>()
    val resultLive: LiveData<List<String>> = _resultLive


    init {
        Log.e("AAA", "VM created!")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared!")
        super.onCleared()
    }

    fun save(
        namePassport: String,
        surnamePassport: String,
        codePassport: String,
        passportNo: String
    ) {

        val infoParams = InfoPassport(
            namePassport = namePassport,
            surnamePassport = surnamePassport,
            codePassport = codePassport,
            passportNo = passportNo
        )

        val result: Boolean = saveInfoPassportUseCase.execute(infoPassport = infoParams)
        _resultLive.value = listOf(result.toString())
    }

    fun load() {
        val namePassport: InfoPassport = getInfoPassportUseCase.execute()
        val surnamePassport: InfoPassport = getInfoPassportUseCase.execute()
        val codePassport: InfoPassport = getInfoPassportUseCase.execute()
        val passportNo: InfoPassport = getInfoPassportUseCase.execute()
        _resultLive.value = listOf(
            namePassport.namePassport,
            surnamePassport.surnamePassport,
            codePassport.codePassport,
            passportNo.passportNo
        )
    }

}
