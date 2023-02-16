package com.example.passportdata.domain.usecase

import com.example.passportdata.domain.models.InfoPassport
import com.example.passportdata.domain.repository.InfoRepository

class GetInfoPassportUseCase(private val infoRepository: InfoRepository) {

    fun execute(): InfoPassport {
        return infoRepository.getInfoPassport()
    }
}
