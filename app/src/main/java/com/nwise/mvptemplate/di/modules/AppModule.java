package com.nwise.mvptemplate.di.modules;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nwise.mvptemplate.MainApplication;
import com.nwise.mvptemplate.domain.executer.NetworkJobExecutor;
import com.nwise.mvptemplate.domain.executer.PostExecutionThread;
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor;
import com.nwise.mvptemplate.network.AppApi;
import com.nwise.mvptemplate.network.Repository;
import com.nwise.mvptemplate.network.RestDataSource;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class AppModule {

    private final MainApplication application;

    public AppModule(@NonNull MainApplication context) {
        this.application = context;
    }

    @NonNull
    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    MainApplication provideApplication() {
        return this.application;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @NonNull
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(AppApi.BASE_URL)
                //.client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Repository provideDataRepository(RestDataSource restDataSource) {
        return restDataSource;
    }

    @NonNull
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }


    @NonNull
    @Provides
    @Singleton
    public UseCaseExecutor provideUseCaseExecutor() {
        return new NetworkJobExecutor();
    }

    @NonNull
    @Provides
    @Singleton
    public PostExecutionThread postExecutionThread() {
        return AndroidSchedulers::mainThread;
    }
}
