package com.nwise.mvptemplate;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import com.nwise.mvptemplate.di.components.ActivityComponent;
import com.nwise.mvptemplate.di.components.AppComponent;
import com.nwise.mvptemplate.di.components.DaggerAppComponent;
import com.nwise.mvptemplate.di.modules.ActivityModule;
import com.nwise.mvptemplate.di.modules.AppModule;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class MainApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public  static ActivityComponent getComponent(AppCompatActivity activity) {
        return component.plus(new ActivityModule(activity));
    }

}
