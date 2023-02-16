package com.example.passportdata.data.repository

import com.example.passportdata.data.storage.models.Info
import com.example.passportdata.data.storage.InfoStorage
import com.example.passportdata.domain.models.InfoPassport
import com.example.passportdata.domain.repository.InfoRepository

class InfoRepositoryImpl(private val infoStorage: InfoStorage) : InfoRepository {

    override fun saveInfoPassport(saveInfo: InfoPassport): Boolean {
        val info = Info(
            namePassport = saveInfo.namePassport,
            surnamePassport = saveInfo.surnamePassport,
            codePassport = saveInfo.codePassport,
            passportNo = saveInfo.passportNo
        )
        return infoStorage.saveInfo(info)
    }

    override fun getInfoPassport(): InfoPassport {
        val info = infoStorage.getInfo()
        return InfoPassport(
            namePassport = info.namePassport,
            surnamePassport = info.surnamePassport,
            codePassport = info.codePassport,
            passportNo = info.passportNo
        )
    }


}