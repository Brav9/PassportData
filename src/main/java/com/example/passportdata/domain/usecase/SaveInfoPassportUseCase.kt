package com.example.passportdata.domain.usecase

import com.example.passportdata.domain.models.InfoPassport
import com.example.passportdata.domain.repository.InfoRepository

class SaveInfoPassportUseCase(private val infoRepository: InfoRepository) {

    fun execute(infoPassport: InfoPassport) :Boolean {
        return infoRepository.saveInfoPassport(saveInfo = infoPassport)
    }
}