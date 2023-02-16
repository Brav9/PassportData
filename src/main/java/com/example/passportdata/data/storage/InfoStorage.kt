package com.example.passportdata.data.storage

import com.example.passportdata.data.storage.models.Info

interface InfoStorage {

    fun getInfo(): Info

    fun saveInfo(info: Info): Boolean
}