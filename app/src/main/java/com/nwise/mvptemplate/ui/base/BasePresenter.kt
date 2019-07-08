package com.nwise.mvptemplate.ui.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
abstract class BasePresenter<V> : AbstractPresenter<V>() {

    private var isFirstTime = true
    private val compositeDisposable = CompositeDisposable()

    override fun onViewAttached(view: V) {
        super.onViewAttached(view)
        if (isFirstTime) {
            isFirstTime = false
            onViewAttachedForFirstTime(view)
        }
    }

    protected fun onViewAttachedForFirstTime(view: V) {}

    protected fun addDisposable(disposable: CompositeDisposable) {
        compositeDisposable.add(disposable)
    }

    override fun onViewDetached() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed)
            compositeDisposable.dispose()
        super.onViewDetached()
    }
}
