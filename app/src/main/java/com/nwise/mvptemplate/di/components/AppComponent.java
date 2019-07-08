package com.nwise.mvptemplate.di.components;

import com.nwise.mvptemplate.di.modules.ActivityModule;
import com.nwise.mvptemplate.di.modules.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@Singleton
@Component(modules = {AppModule.class })
public interface AppComponent {

    ActivityComponent plus(ActivityModule module);


}