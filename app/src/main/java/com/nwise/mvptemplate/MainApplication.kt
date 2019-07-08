package com.nwise.mvptemplate

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.nwise.mvptemplate.di.components.ActivityComponent
import com.nwise.mvptemplate.di.components.AppComponent
import com.nwise.mvptemplate.di.components.DaggerAppComponent
import com.nwise.mvptemplate.di.modules.ActivityModule
import com.nwise.mvptemplate.di.modules.AppModule

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {

        private var component: AppComponent? = null

        fun getComponent(activity: AppCompatActivity): ActivityComponent {
            return component!!.plus(ActivityModule(activity))
        }
    }

}
