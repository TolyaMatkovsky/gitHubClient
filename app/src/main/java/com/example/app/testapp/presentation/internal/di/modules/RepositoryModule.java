package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.domain.repository.GitHubRepository;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tolik on 13.02.2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    DBGitHubRepository provideDBGitHubRepository(RealmGitHubRepositoryImpl realmGitHubRepository){
        return realmGitHubRepository;
    }
}
