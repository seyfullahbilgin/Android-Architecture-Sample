package net.kariyer.techchallenge.ui.login

import net.kariyer.techchallenge.ui.base.BaseController

interface LoginController : BaseController {

    fun gotoOrderFragment()
    fun showMessage(message:String)
}