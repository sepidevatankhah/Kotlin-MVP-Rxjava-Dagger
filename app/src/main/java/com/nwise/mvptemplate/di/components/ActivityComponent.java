package com.hamrah.sun.sunpayment.injectors.components;

import com.hamrah.sun.sunpayment.injectors.modules.ActivityModule;
import com.hamrah.sun.sunpayment.injectors.modules.DialogModule;
import com.hamrah.sun.sunpayment.injectors.modules.DialogSheetModule;
import com.hamrah.sun.sunpayment.injectors.modules.FragmentModule;
import com.hamrah.sun.sunpayment.injectors.scopes.ActivityScope;
//import com.hamrah.sun.sunpayment.ui.activation.ActivationActivity;
import com.hamrah.sun.sunpayment.ui.main.MainActivity;
import com.hamrah.sun.sunpayment.ui.register.RegisterActivity;
import com.smule.suntech.app.injector.component.DialogComponent;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(RegisterActivity registerActivity);

    //void inject(ActivationActivity loginActivity);

    FragmentComponent plus(FragmentModule module);
    DialogComponent plus(DialogModule module);
    DialogSheetComponent plus(DialogSheetModule module);
}
