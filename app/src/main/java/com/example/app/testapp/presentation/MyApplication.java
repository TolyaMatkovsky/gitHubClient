package com.example.app.testapp.presentation;

import android.app.Application;

import com.example.app.testapp.data.manager.SettingsManager;
import com.example.app.testapp.presentation.internal.di.components.ApplicationComponent;
import com.example.app.testapp.presentation.internal.di.components.DaggerApplicationComponent;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Tolik on 10.02.2017.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        SettingsManager.getInstance(this);

        initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
