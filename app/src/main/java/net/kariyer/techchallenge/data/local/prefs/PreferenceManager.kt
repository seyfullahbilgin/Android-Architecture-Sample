package net.kariyer.techchallenge.data.local.prefs

import android.content.Context
import androidx.preference.PreferenceManager

class PreferenceManager(context: Context) {

    private var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)


    var userName: String?
        get() = sharedPreferences.getString(PreferenceType.USER_NAME.toString(), "kariyer")
        set(value) = sharedPreferences.edit().putString(PreferenceType.USER_NAME.toString(), value).apply()

    var password: String?
        get() = sharedPreferences.getString(PreferenceType.PASSWORD.toString(), "2019ADev")
        set(value) = sharedPreferences.edit().putString(PreferenceType.PASSWORD.toString(), value).apply()

    var rememberMe: Boolean
        get() = sharedPreferences.getBoolean(PreferenceType.REMEMBER_ME.toString(), false)
        set(value) = sharedPreferences.edit().putBoolean(PreferenceType.REMEMBER_ME.toString(), value).apply()

    var autoLogin: Boolean
        get() = sharedPreferences.getBoolean(PreferenceType.AUTO_LOGIN.toString(), false)
        set(value) = sharedPreferences.edit().putBoolean(PreferenceType.AUTO_LOGIN.toString(), value).apply()
}
