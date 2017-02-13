package com.example.app.testapp.domain.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Tolik on 10.02.2017.
 */
@Singleton
public class UpdateUserInterfaceThread implements PostExecutionThread {
    @Inject
    public UpdateUserInterfaceThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
