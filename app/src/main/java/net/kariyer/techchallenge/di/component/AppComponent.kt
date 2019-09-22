package net.kariyer.techchallenge.di.component

import android.app.Application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.kariyer.techchallenge.App
import net.kariyer.techchallenge.di.module.ActivityBindingModule
import net.kariyer.techchallenge.di.module.AppModule

import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<App> {

    // Gives us syntactic sugar, we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

