package com.example.app.testapp.data.entity.mapper;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.pojo.GithubUser;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class UserDataMapper {
    @Inject
    public UserDataMapper() {
    }

    public User transform(GithubUser githubUser){
        User user = null;
        if(githubUser != null){
            user = new User(githubUser.getId());
            user.setLoginName(githubUser.getLogin());
            user.setName(githubUser.getName());
            user.setCompany(githubUser.getCompany());
            user.setEmail(githubUser.getEmail());
            user.setAvatarURL(githubUser.getAvatarUrl());
            user.setHtmlURL(githubUser.getHtmlUrl());
            user.setFollowers(githubUser.getFollowers());
            user.setFollowing(githubUser.getFollowing());
            user.setPublicGists(githubUser.getPublicGists());
            user.setPublicRepos(githubUser.getPublicRepos());
        }
        return user;
    }
}
