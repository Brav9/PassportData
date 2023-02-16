package com.example.passportdata.domain.repository

import com.example.passportdata.domain.models.InfoPassport

interface InfoRepository {

   fun getInfoPassport(): InfoPassport

   fun saveInfoPassport(saveInfo: InfoPassport): Boolean
}