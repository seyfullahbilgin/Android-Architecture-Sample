package net.kariyer.techchallenge

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.kariyer.techchallenge.di.component.AppComponent
import net.kariyer.techchallenge.di.component.DaggerAppComponent

class App : DaggerApplication() {

    //to able to extend DaggerApplication class we should override this method
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        return appComponent
    }

    companion object {
        lateinit var appComponent: AppComponent
    }

}