package net.kariyer.techchallenge.di.module


import android.content.Context
import net.kariyer.techchallenge.data.local.prefs.PreferenceManager
import net.kariyer.techchallenge.data.local.resource.ResourceProvider

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DataModule {


    //This method provides the resources of context such as R.string, R.color
    @Provides
    @Singleton
    fun getResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context)
    }

    //This method provides the application preferences
    @Provides
    @Singleton
    fun getPreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager(context)
    }
}