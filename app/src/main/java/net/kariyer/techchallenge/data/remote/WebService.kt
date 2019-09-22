package net.kariyer.techchallenge.data.remote

import kotlinx.coroutines.Deferred
import net.kariyer.techchallenge.data.entitiy.Product
import retrofit2.http.*

interface WebService {

    @GET("/")
    fun getMyOrders(): Deferred<ArrayList<Product>>

    //Another web service which provides more data from mock.io
    //It is inside the net module
  /*  @GET("v2/5d868c9434000098000a1390")
    fun getMyOrders(): Deferred<ArrayList<Product>>*/
}

