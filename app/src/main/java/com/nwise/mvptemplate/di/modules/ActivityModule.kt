package com.nwise.mvptemplate.di.modules

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides


/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@Module
class ActivityModule(internal val mActivity: Activity) {

    @Provides
    fun context(): Context {
        return activity()
    }

    @Provides
    fun activity(): Activity {
        return mActivity
    }

    @Provides
    internal fun layoutInflater(): LayoutInflater {
        return mActivity.layoutInflater
    }
}
