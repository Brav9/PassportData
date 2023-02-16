package com.example.passportdata.data.storage.SharedPrefs

import android.content.Context
import androidx.core.content.edit
import com.example.passportdata.data.storage.InfoStorage
import com.example.passportdata.data.storage.models.Info

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KAY_NAME = "name"
private const val KAY_SURNAME = "surname"
private const val KAY_CODE = "0"
private const val KAY_NO = "0"
private const val DEFAULT_NAME = ""
private const val DEFAULT_SURNAME = ""
private const val DEFAULT_CODE = ""
private const val DEFAULT_NO = ""


class SharedPrefsInfoStorage(context: Context) : InfoStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getInfo(): Info {
        val name = sharedPreferences.getString(KAY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val surname = sharedPreferences.getString(KAY_SURNAME, DEFAULT_SURNAME) ?: DEFAULT_SURNAME
        val code = sharedPreferences.getString(KAY_CODE, DEFAULT_CODE) ?: DEFAULT_CODE
        val no = sharedPreferences.getString(KAY_NO, DEFAULT_NO) ?: DEFAULT_NO

        return Info(
            namePassport = name,
            surnamePassport = surname,
            codePassport = code,
            passportNo = no
        )
    }

    override fun saveInfo(info: Info): Boolean {
        sharedPreferences.edit().putString(KAY_NAME, info.namePassport).apply()
        sharedPreferences.edit().putString(KAY_SURNAME, info.surnamePassport).apply()
        sharedPreferences.edit().putString(KAY_CODE, info.codePassport).apply()
        sharedPreferences.edit().putString(KAY_NO, info.passportNo).apply()

        return true
    }

}