package com.example.app.testapp.data.service;

import android.graphics.Bitmap;

import com.example.app.testapp.data.pojo.GitHubUserRepository;
import com.example.app.testapp.data.pojo.GithubUser;
import com.example.app.testapp.data.pojo.PrivateUser;
import com.example.app.testapp.data.pojo.PrivateUserRepos;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Tolik on 11.02.2017.
 */

public interface GitHubService {

    @GET("users/{username}")
    Observable<GithubUser> getGitHubUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Observable<List<GitHubUserRepository>> getUserRepositories(@Path("username") String username);

    @GET
    Observable<Bitmap> getImage(@Url String url);

    @GET("user")
    Observable<PrivateUser> getPrivateUser();

    @GET("/user/repos")
    Observable<List<PrivateUserRepos>> getPrivateRepos();
}
