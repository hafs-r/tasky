package com.hafsalrahman.tasky;

import android.app.Application;

import com.hafsalrahman.tasky.di.component.DaggerNetComponent;
import com.hafsalrahman.tasky.di.component.NetComponent;
import com.hafsalrahman.tasky.di.module.AppModule;
import com.hafsalrahman.tasky.di.module.NetModule;

/**
 * @author hafsalrahman on 7/19/17.
 * */
public class TaskyApplication extends Application {

    private static NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://5971f1a0fcf1680011f2eb69.mockapi.io/tasky/api/"))
                .build();
    }

    public static NetComponent getNetComponent() {
        return mNetComponent;
    }

}