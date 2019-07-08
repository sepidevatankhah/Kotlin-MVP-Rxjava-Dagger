package com.nwise.mvptemplate;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.nwise.mvptemplate.di.components.ActivityComponent;
import com.nwise.mvptemplate.di.components.AppComponent;
import com.nwise.mvptemplate.di.components.DaggerAppComponent;
import com.nwise.mvptemplate.di.modules.ActivityModule;
import com.nwise.mvptemplate.di.modules.AppModule;

public class MainApplication extends Application {

    private static AppComponent component;

//    @NonNull
//    public static AppComponent getComponent(Context context) {
//        return ((MainApplication) context.getApplicationContext()).getComponent();
//    }
//
//    @NonNull
//    private AppComponent getComponent() {
//        return component;
//    }


    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }



    public  static ActivityComponent getComponent(AppCompatActivity activity) {
        return component.plus(new ActivityModule(activity));
    }

}
