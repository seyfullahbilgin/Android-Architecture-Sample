package net.kariyer.techchallenge.ui.orders

import net.kariyer.techchallenge.data.entitiy.ProductViewState

interface OrderItemStateCallback {

    fun onStateChanged(position: Int, state: ProductViewState)
}