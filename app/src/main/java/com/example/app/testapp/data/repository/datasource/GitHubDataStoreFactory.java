package com.example.app.testapp.data.repository.datasource;

import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class GitHubDataStoreFactory {
    @Inject
    public GitHubDataStoreFactory() {
    }

    public GitHubDataStore createCloudDataStore(){
        return new CloudGitHubDataStore();
    }

    public GitHubDataStore createCloudDataStore(AccessToken accessToken){
        return new CloudGitHubDataStore(accessToken);
    }
}
