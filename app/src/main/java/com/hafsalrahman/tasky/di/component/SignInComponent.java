package com.hafsalrahman.tasky.di.component;

import com.hafsalrahman.tasky.signin.SignActivity;
import com.hafsalrahman.tasky.di.module.SignInModule;
import com.hafsalrahman.tasky.di.extra.CustomScope;

import dagger.Component;

/**
 * Created by hafsal on 7/23/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = SignInModule.class)
public interface SignInComponent {
    void inject(SignActivity activity);
}
