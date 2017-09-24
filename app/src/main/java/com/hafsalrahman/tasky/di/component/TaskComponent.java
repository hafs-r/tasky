package com.hafsalrahman.tasky.di.component;

import com.hafsalrahman.tasky.di.module.TaskModule;
import com.hafsalrahman.tasky.ui.task.TaskActivity;
import com.hafsalrahman.tasky.di.extra.CustomScope;

import dagger.Component;

/**
 * Created by hafsal on 7/23/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = TaskModule.class)
public interface TaskComponent {
    void inject(TaskActivity activity);
}
