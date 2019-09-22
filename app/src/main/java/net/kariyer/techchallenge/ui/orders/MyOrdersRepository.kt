package net.kariyer.techchallenge.ui.orders

import net.kariyer.techchallenge.R
import net.kariyer.techchallenge.data.entitiy.Product
import net.kariyer.techchallenge.data.local.resource.ResourceProvider
import net.kariyer.techchallenge.data.remote.WebService
import net.kariyer.techchallenge.ui.base.BaseRepository
import net.kariyer.techchallenge.common.Result
import net.kariyer.techchallenge.data.local.prefs.PreferenceManager

import javax.inject.Inject

class MyOrdersRepository
@Inject
constructor() : BaseRepository() {

    @Inject
    lateinit var webService: WebService

    @Inject
    lateinit var prefs: PreferenceManager

    @Inject
    lateinit var resource: ResourceProvider

    suspend fun getMyOrders(): Result<ArrayList<Product>> {

        return try {

            var response = webService.getMyOrders().await()

            if (response.size == 0)
                Result.Error(Exception(resource.getString(R.string.you_have_not_any_order)))
            else
                Result.Success(response)

        } catch (e: Exception) {
            Result.Error(Exception(resource.getString(R.string.sorry_an_error_has_occurred)))
        }
    }


    fun logout() {
        prefs.autoLogin = false
    }


}



