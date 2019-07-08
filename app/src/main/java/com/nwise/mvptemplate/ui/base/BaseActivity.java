package com.nwise.mvptemplate.ui.base;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.nwise.mvptemplate.MainApplication;
import com.nwise.mvptemplate.di.components.ActivityComponent;
import javax.inject.Inject;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P presenter;

    protected abstract void injectDependencies(ActivityComponent component);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectDependencies(new MainApplication().getComponent(this));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null)
            presenter.onViewAttached(this);
    }

    @Override
    protected void onStop() {
        if (presenter != null)
            presenter.onViewDetached();
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.onDestroy();
    }
}
