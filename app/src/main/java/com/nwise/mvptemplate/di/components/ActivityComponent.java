package com.nwise.mvptemplate.di.components;

import com.nwise.mvptemplate.di.modules.ActivityModule;
import com.nwise.mvptemplate.di.scopes.ActivityScope;
import com.nwise.mvptemplate.ui.main.MainActivity;
import dagger.Subcomponent;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
