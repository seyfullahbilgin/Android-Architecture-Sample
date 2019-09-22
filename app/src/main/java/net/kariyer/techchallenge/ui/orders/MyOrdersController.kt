package net.kariyer.techchallenge.ui.orders

import net.kariyer.techchallenge.ui.base.BaseController

interface MyOrdersController : BaseController {

    fun gotoLoginFragment()
    fun showMessage(message:String)
    fun showErrorMessage(message:String)
}