package com.nwise.mvptemplate.di.components;

import com.nwise.mvptemplate.di.modules.ActivityModule;
import com.nwise.mvptemplate.di.modules.AppModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class })
public interface AppComponent {

    ActivityComponent plus(ActivityModule module);


}