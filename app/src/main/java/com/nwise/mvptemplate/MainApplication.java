package com.nwise.sunshine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.nwise.sunshine.di.component.ActivityComponent;
import com.nwise.sunshine.di.component.AppComponent;
import com.nwise.sunshine.di.component.FragmentComponent;
import com.nwise.sunshine.di.module.ActivityModule;
import com.nwise.sunshine.di.module.FragmentModule;

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
       // component = DaggerAppComponent.builder().build();
    }

    public  static FragmentComponent getComponent(Fragment fragment) {
        assert (fragment.getActivity() != null);
        Activity activity = fragment.getActivity();
        return component.plus(new ActivityModule(activity)).plus(new FragmentModule(fragment));
    }

    public  static ActivityComponent getComponent(AppCompatActivity activity) {
        return component.plus(new ActivityModule(activity));
    }

}
