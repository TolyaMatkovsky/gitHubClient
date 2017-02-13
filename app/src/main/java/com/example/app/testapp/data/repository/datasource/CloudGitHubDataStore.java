package com.example.app.testapp.data.repository.datasource;

import com.example.app.testapp.data.pojo.GitHubUserRepository;
import com.example.app.testapp.data.pojo.GithubUser;
import com.example.app.testapp.data.pojo.PrivateUser;
import com.example.app.testapp.data.pojo.PrivateUserRepos;
import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.data.service.GitHubService;
import com.example.app.testapp.data.service.ServiceGenerator;

import java.util.List;

import rx.Observable;

/**
 * Created by Tolik on 11.02.2017.
 */

public class CloudGitHubDataStore implements GitHubDataStore {
    private AccessToken accessToken;

    public CloudGitHubDataStore() {
    }

    public CloudGitHubDataStore(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Observable<GithubUser> userGitHub(String username) {
        return ServiceGenerator.createService(GitHubService.class).getGitHubUser(username);
    }

    @Override
    public Observable<List<GitHubUserRepository>> userRepositories(String userName) {
        return ServiceGenerator.createService(GitHubService.class).getUserRepositories(userName);
    }

    @Override
    public Observable<PrivateUser> privateUser() {
        return ServiceGenerator.createService(GitHubService.class, accessToken).getPrivateUser();
    }

    @Override
    public Observable<List<PrivateUserRepos>> privateUserRepos() {
        return ServiceGenerator.createService(GitHubService.class, accessToken).getPrivateRepos();
    }
}
