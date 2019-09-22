package net.kariyer.techchallenge.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.kariyer.techchallenge.common.ViewModelFactory
import net.kariyer.techchallenge.di.key.ViewModelKey
import net.kariyer.techchallenge.ui.login.LoginViewModel
import net.kariyer.techchallenge.ui.orders.MyOrdersViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyOrdersViewModel::class)
    internal abstract fun orderViewModel(viewModel: MyOrdersViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelProviderFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
