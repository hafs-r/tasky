package com.hafsalrahman.tasky.task;

import com.hafsalrahman.tasky.data.component.NetComponent;
import com.hafsalrahman.tasky.util.CustomScope;

import dagger.Component;

/**
 * Created by hafsal on 7/23/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = TaskModule.class)
public interface TaskComponent {
    void inject(TaskActivity activity);
}
