package com.nwise.mvptemplate.ui.base

import java.lang.ref.WeakReference

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
abstract class AbstractPresenter<V> : Presenter<V> {
    internal var view: WeakReference<V>? = null

    override val isViewAttached: Boolean
        get() = view != null && view!!.get() != null

    override fun onViewAttached(view: V) {
        this.view = WeakReference(view)
    }

    override fun onViewDetached() {
        if (view != null)
            view!!.clear()
    }

    override fun onDestroy() {
        if (view != null)
            view!!.clear()
        view = null
    }

    fun getView(): V? {
        return if (view != null) {
            view!!.get()
        } else
            null
    }
}
