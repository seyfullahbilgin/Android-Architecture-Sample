package net.kariyer.techchallenge.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import net.kariyer.techchallenge.data.remote.WebService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Named("serverUrl")
    fun getServerUrl(): String {
        return "http://kariyertechchallenge.mockable.io"
    }

    //Another mock data url
    @Provides
    @Named("testUrl")
    fun getMockServerUrl(): String {
        return "http://www.mocky.io"
    }

    @Provides
    @Singleton
    fun provideWebService(): WebService {
        return getRetrofit(getOkHttpClient(getHttpLoggingInterceptor())).create(WebService::class.java)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getServerUrl())
            //.baseUrl(getMockServerUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}