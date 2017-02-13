package com.example.app.testapp.domain.executor;

import rx.Scheduler;

/**
 * Created by Tolik on 10.02.2017.
 */

public interface PostExecutionThread {
  Scheduler getScheduler();
}
