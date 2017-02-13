package com.example.app.testapp.domain.interactors;

import com.example.app.testapp.data.executor.JobExecutor;
import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.executor.UpdateUserInterfaceThread;
import com.example.app.testapp.domain.repository.GitHubRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by Tolik on 10.02.2017.
 */

public class GitHubUserInteractor extends UseCase {
    protected GitHubRepository gitHubRepository;

    public GitHubUserInteractor(GitHubRepository gitHubRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.gitHubRepository = gitHubRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
            return gitHubRepository.user(getUserName());
    }
}
