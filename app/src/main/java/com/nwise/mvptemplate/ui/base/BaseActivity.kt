package com.nwise.mvptemplate.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nwise.mvptemplate.MainApplication
import com.nwise.mvptemplate.di.components.ActivityComponent
import javax.inject.Inject

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
abstract class BaseActivity<P : BasePresenter<V>, V> : AppCompatActivity() {

    @Inject
    var presenter: P? = null

    protected abstract fun injectDependencies(component: ActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(MainApplication.getComponent(this))
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        if (presenter != null)
            presenter!!.onViewAttached(this as V)
    }

    override fun onStop() {
        if (presenter != null)
            presenter!!.onViewDetached()
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null)
            presenter!!.onDestroy()
    }
}
