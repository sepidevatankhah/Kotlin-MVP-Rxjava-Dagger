package com.nwise.mvptemplate.di.modules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    final Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Context context() {
        return activity();
    }

    @Provides
    public Activity activity() {
        return mActivity;
    }

    @Provides
    LayoutInflater layoutInflater() {
        return mActivity.getLayoutInflater();
    }
}
