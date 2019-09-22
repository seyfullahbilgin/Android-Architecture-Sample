package net.kariyer.techchallenge.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kariyer.techchallenge.ui.login.LoginFragment
import net.kariyer.techchallenge.ui.orders.MyOrdersFragment

@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun orderFragment(): MyOrdersFragment
}
