package com.hafsalrahman.tasky.signin;

import com.hafsalrahman.tasky.data.component.NetComponent;
import com.hafsalrahman.tasky.task.TaskActivity;
import com.hafsalrahman.tasky.util.CustomScope;

import dagger.Component;

/**
 * Created by hafsal on 7/23/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = SignInModule.class)
public interface SignInComponent {
    void inject(SignActivity activity);
}
