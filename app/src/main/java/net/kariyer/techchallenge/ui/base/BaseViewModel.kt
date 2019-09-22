package net.kariyer.techchallenge.ui.base

import androidx.lifecycle.ViewModel
import net.kariyer.techchallenge.util.log

//Base class for all viewmodels
abstract class BaseViewModel<T : BaseController> : ViewModel() {

    //this generic interface provides the communication between viewmodel to fragment
    var controller: T? = null

    override fun onCleared() {
        super.onCleared()
        log("onCleared")
    }

}
