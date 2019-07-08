package com.nwise.mvptemplate.ui.base;

import com.nwise.mvptemplate.di.components.ActivityComponent;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V> extends AbstractPresenter<V> {

    private boolean isFirstTime = true;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onViewAttached(V view) {
        super.onViewAttached(view);
        if (isFirstTime) {
            isFirstTime = false;
            onViewAttachedForFirstTime(view);
        }
    }

    protected void onViewAttachedForFirstTime(V view) {
    }

    protected void addDisposable(CompositeDisposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onViewDetached() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
        super.onViewDetached();
    }
}
