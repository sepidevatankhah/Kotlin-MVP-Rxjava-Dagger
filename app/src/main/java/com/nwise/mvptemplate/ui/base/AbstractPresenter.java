package com.nwise.mvptemplate.ui.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V> implements Presenter<V> {
    WeakReference<V> view = new WeakReference();
    @Override
    public void onViewAttached(V view) {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public boolean isViewAttached() {
        return false;
    }
}
