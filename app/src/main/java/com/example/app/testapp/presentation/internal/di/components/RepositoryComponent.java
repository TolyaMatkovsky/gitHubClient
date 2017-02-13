package com.example.app.testapp.presentation.internal.di.components;

import android.content.Context;

import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.domain.repository.GitHubRepository;
import com.example.app.testapp.presentation.activity.BaseActivity;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule;
import com.example.app.testapp.presentation.internal.di.modules.RepositoryModule;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by Tolik on 13.02.2017.
 */
@RepositoryScope
@Component(dependencies = ApplicationComponent.class, modules = {RepositoryModule.class})
public interface RepositoryComponent {
    void inject(BaseActivity baseActivity);

    DBGitHubRepository provideDBRepository();

    PrivateUserDataRepository providePrivateRepository();
    GitHubDataRepository provideRepository();

    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

    Context provideContext();
}
