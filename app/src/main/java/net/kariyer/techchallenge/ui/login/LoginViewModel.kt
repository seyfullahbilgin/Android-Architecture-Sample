package net.kariyer.techchallenge.ui.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import net.kariyer.techchallenge.R
import net.kariyer.techchallenge.data.local.resource.ResourceProvider
import net.kariyer.techchallenge.ui.base.BaseViewModel

import javax.inject.Inject

class LoginViewModel
@Inject
constructor(private val repository: LoginRepository) : BaseViewModel<LoginController>() {

    //We inject the resource provider from dagger to able to use strings, colors in the viewmodel
    @Inject
    lateinit var resourceProvider: ResourceProvider

    //These are bounded in xml layout file to able to update data automatically
    val userName = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    var rememberMe: Boolean
        get() = repository.rememberMe
        set(value) {

            if (repository.rememberMe == value)
                return

            repository.rememberMe = value
        }


    var autoLogin: Boolean
        get() = repository.autoLogin
        set(value) {
            repository.autoLogin = value
        }

    //Length of the user name should contains more than 2 characters
    private val isUserNameValid: LiveData<Boolean> =
        Transformations.map(userName) {
            it.length >= 3
        }

    //Length of the user password should contains more than 4 characters
    private val isPasswordValid: LiveData<Boolean> =
        Transformations.map(password) {
            it.length >= 5
        }

    //This property contains boolean value which bounded the enabled property of login button in the xml layout
    val isValid = validate()


    //We check the user name and password to be able to validate them
    private fun validate(): LiveData<Boolean> {

        val result = MediatorLiveData<Boolean>()

        result.addSource(isUserNameValid) {
            result.value = (isUserNameValid.value ?: false) && (isPasswordValid.value ?: false)
        }
        result.addSource(isPasswordValid) {
            result.value = (isUserNameValid.value ?: false) && (isPasswordValid.value ?: false)
        }
        return result
    }

    //Returns the message about the login status
    val message: LiveData<String> =
        Transformations.map(isValid) {
            if (it == false)
                resourceProvider.getString(R.string.please_fill_in_the_required_fields_correctly)
            else ""
        }

    //This method can be useful to save authorization data of user
    fun saveUserInfo(userName: String, password: String) =
        repository.saveUserInfo(userName, password)

    fun login(userName: String, password: String) {

        var isUser = repository.login(userName, password)

        if (isUser) {
            autoLogin = true
            controller?.gotoOrderFragment()
            controller?.showMessage(resourceProvider.getString(R.string.you_have_been_logged_in))
        } else {
            controller?.showMessage(resourceProvider.getString(R.string.invalid_user_name_or_password))
        }
    }

    fun autoLogin() {
        if (rememberMe && autoLogin)
            controller?.gotoOrderFragment()
    }

    fun getUserName(): String {
        return repository.getUserName()
    }

    fun getUserPassword(): String {
        return repository.getUserPassword()
    }
}






