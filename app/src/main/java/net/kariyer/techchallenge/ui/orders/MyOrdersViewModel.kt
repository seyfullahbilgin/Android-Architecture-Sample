package net.kariyer.techchallenge.ui.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.kariyer.techchallenge.R
import net.kariyer.techchallenge.common.Result
import net.kariyer.techchallenge.data.entitiy.Product
import net.kariyer.techchallenge.data.local.resource.ResourceProvider
import net.kariyer.techchallenge.ui.base.BaseViewModel
import net.kariyer.techchallenge.util.log

import javax.inject.Inject

class MyOrdersViewModel
@Inject
constructor(private val repository: MyOrdersRepository) : BaseViewModel<MyOrdersController>() {

    //We inject the resource provider from dagger to able to use strings, colors in the viewmodel
    @Inject
    lateinit var resourceProvider: ResourceProvider

    //We fetch data of orders from network by using kotlin coroutines which is more effective than RxJava callbacks
    fun getMyOrders(): MutableLiveData<ArrayList<Product>> {

        val myOrders = MutableLiveData<ArrayList<Product>>()

        viewModelScope.launch {

            var result = repository.getMyOrders()

            when (result) {

                is Result.Success ->
                    myOrders.value = result.data
                is Result.Error ->
                    controller?.showMessage(result.exception.message.toString())

                else -> log("loading...")
            }
        }

        return myOrders
    }

    //We log out and show message
    fun logout() {
        repository.logout()
        controller?.showMessage(resourceProvider.getString(R.string.you_have_been_logged_out))
        controller?.gotoLoginFragment()
    }
}



