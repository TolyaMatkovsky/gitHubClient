package com.example.app.testapp.data.entity.mapper;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.pojo.PrivateUser;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class PrivateUserDataMapper {
    @Inject
    public PrivateUserDataMapper() {
    }

    public User transform(PrivateUser privateUser){
        User user = null;
        if(privateUser != null){
            user = new User(privateUser.getId());
            user.setLoginName(privateUser.getLogin());
            user.setName(privateUser.getName());
            user.setCompany(privateUser.getCompany());
            user.setEmail(privateUser.getEmail());
            user.setAvatarURL(privateUser.getAvatarUrl());
            user.setHtmlURL(privateUser.getHtmlUrl());
            user.setFollowers(privateUser.getFollowers());
            user.setFollowing(privateUser.getFollowing());
            user.setPublicGists(privateUser.getPublicGists());
            user.setPublicRepos(privateUser.getPublicRepos());
        }
        return user;
    }
}
