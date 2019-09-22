package net.kariyer.techchallenge.di.module

import net.kariyer.techchallenge.ui.orders.MyOrdersFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kariyer.techchallenge.di.scope.ActivityScoped
import net.kariyer.techchallenge.ui.login.LoginFragmentModule
import net.kariyer.techchallenge.ui.main.MainActivity
import net.kariyer.techchallenge.ui.main.MainActivityFragmentModule
import net.kariyer.techchallenge.ui.main.MainActivityModule

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainActivityFragmentModule::class,
            LoginFragmentModule::class,
            MyOrdersFragmentModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity
}