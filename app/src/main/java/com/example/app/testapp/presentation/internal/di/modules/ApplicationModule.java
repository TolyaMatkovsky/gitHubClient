/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.app.testapp.presentation.internal.di.modules;

import android.content.Context;

import com.example.app.testapp.data.executor.JobExecutor;
import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.executor.UpdateUserInterfaceThread;
import com.example.app.testapp.domain.repository.GitHubRepository;
import com.example.app.testapp.presentation.MyApplication;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final MyApplication application;

  public ApplicationModule(MyApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides
  @Singleton
  Realm provideRealmDatabase() {
    Realm.init(this.application);
    RealmConfiguration config = new RealmConfiguration.Builder()
            .name("github.realm")
            .build();
    Realm.setDefaultConfiguration(config);

    return Realm.getDefaultInstance();
  }

  @Provides
  @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides
  @Singleton
  PostExecutionThread providePostExecutionThread(UpdateUserInterfaceThread uiThread) {
    return uiThread;
  }
}
