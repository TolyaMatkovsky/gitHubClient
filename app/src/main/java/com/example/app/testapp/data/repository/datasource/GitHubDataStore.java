package com.example.app.testapp.data.repository.datasource;

import com.example.app.testapp.data.pojo.GitHubUserRepository;
import com.example.app.testapp.data.pojo.GithubUser;
import com.example.app.testapp.data.pojo.PrivateUser;
import com.example.app.testapp.data.pojo.PrivateUserRepos;

import java.util.List;

import rx.Observable;

/**
 * Created by Tolik on 11.02.2017.
 */

public interface GitHubDataStore {
    Observable<GithubUser> userGitHub(String username);
    Observable<List<GitHubUserRepository>> userRepositories(String userName);

    Observable<PrivateUser> privateUser();
    Observable<List<PrivateUserRepos>> privateUserRepos();
}
