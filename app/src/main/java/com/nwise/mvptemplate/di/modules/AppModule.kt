package com.nwise.mvptemplate.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nwise.mvptemplate.MainApplication
import com.nwise.mvptemplate.domain.executer.NetworkJobExecutor
import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.network.AppApi
import com.nwise.mvptemplate.network.Repository
import com.nwise.mvptemplate.network.RestDataSource
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */

@Module
class AppModule(@param:NonNull private val application: MainApplication) {

    @NonNull
    @Provides
    internal fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    internal fun provideApplication(): MainApplication {
        return this.application
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @NonNull
    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(AppApi.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideDataRepository(restDataSource: RestDataSource): Repository {
        return restDataSource
    }

    @NonNull
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
    }


    @NonNull
    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor {
        return NetworkJobExecutor()
    }

    @NonNull
    @Provides
    @Singleton
    fun postExecutionThread(): PostExecutionThread {
        return object :PostExecutionThread{
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()
        }
    }
}
