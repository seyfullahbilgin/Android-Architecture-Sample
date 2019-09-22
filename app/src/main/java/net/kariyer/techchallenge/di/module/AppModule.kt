package net.kariyer.techchallenge.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

//We include the our modules to the AppModule
@Module(includes = [NetModule::class, DataModule::class, ViewModelModule::class])
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context
}
