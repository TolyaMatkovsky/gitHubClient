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

import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.GitHubUserInteractor;
import com.example.app.testapp.domain.interactors.UseCase;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.presentation.fragments.presenter.ResultPresenter;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import com.example.app.testapp.presentation.internal.di.PerFragment;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class GitHubUserModule {

  public GitHubUserModule() {}

  @Provides
  @PerFragment
  @Named("all")
  UseCase provideAllUseCase(GitHubDataRepository gitHubDataRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GitHubUserInteractor(gitHubDataRepository, threadExecutor, postExecutionThread);
  }

  @Provides
  @PerFragment
  @Named("private")
  UseCase providePrivateUseCase(PrivateUserDataRepository privateUserDataRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GitHubUserInteractor(privateUserDataRepository, threadExecutor, postExecutionThread);
  }

}