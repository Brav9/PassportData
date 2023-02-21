package com.example.passportdata.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.passportdata.data.repository.InfoRepositoryImpl
import com.example.passportdata.data.storage.SharedPrefs.SharedPrefsInfoStorage
import com.example.passportdata.domain.usecase.GetInfoPassportUseCase
import com.example.passportdata.domain.usecase.SaveInfoPassportUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val infoRepository by lazy {
        InfoRepositoryImpl(
            infoStorage = SharedPrefsInfoStorage(
                context = context
            )
        )
    }

    private val saveInfoPassportUseCase by lazy {
        SaveInfoPassportUseCase(infoRepository = infoRepository)
    }

    private val getInfoPassportUseCase by lazy {
        GetInfoPassportUseCase(infoRepository = infoRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getInfoPassportUseCase = getInfoPassportUseCase,
            saveInfoPassportUseCase = saveInfoPassportUseCase
        ) as T
    }
}