package com.hafsalrahman.tasky.di.module;

import com.hafsalrahman.tasky.ui.task.TaskContract;
import com.hafsalrahman.tasky.di.extra.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hafsal on 7/23/17.
 */

@Module
public class TaskModule {
    private final TaskContract.View mView;

    public TaskModule(TaskContract.View mView) {
        this.mView = mView;
    }
    @Provides
    @CustomScope
    TaskContract.View providesTaskContractView() {
        return mView;
    }
}
