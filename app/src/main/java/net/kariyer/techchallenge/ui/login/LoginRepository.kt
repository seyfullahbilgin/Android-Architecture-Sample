package net.kariyer.techchallenge.ui.login


import net.kariyer.techchallenge.data.local.prefs.PreferenceManager
import javax.inject.Inject
import net.kariyer.techchallenge.ui.base.BaseRepository

class LoginRepository
@Inject
constructor() : BaseRepository() {
    
    @Inject
    lateinit var prefs: PreferenceManager

    fun saveUserInfo(userName: String, password: String) {
        prefs.userName = userName
        prefs.userName = password
    }

    fun login(userName: String, password: String) =
        userName == prefs.userName && password == prefs.password

    var rememberMe: Boolean
        get() = prefs.rememberMe
        set(value) {
            prefs.rememberMe = value
        }

    var autoLogin: Boolean
        get() = prefs.autoLogin
        set(value) {
            prefs.autoLogin = value
        }

    fun getUserName(): String {
        return prefs.userName.toString()
    }

    fun getUserPassword(): String {
        return prefs.password.toString()
    }
}



