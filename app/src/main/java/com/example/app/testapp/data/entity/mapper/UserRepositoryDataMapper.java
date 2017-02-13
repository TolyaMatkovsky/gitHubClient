package com.example.app.testapp.data.entity.mapper;

import com.example.app.testapp.data.entity.UserRepository;
import com.example.app.testapp.data.pojo.GitHubUserRepository;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class UserRepositoryDataMapper {
    @Inject
    public UserRepositoryDataMapper() {
    }

    public UserRepository transform(GitHubUserRepository pojoRepository){
        UserRepository userRepository = null;
        if(pojoRepository != null){
            userRepository = new UserRepository(pojoRepository.getId());
            userRepository.setRepositoryTitle(pojoRepository.getName());
            userRepository.setLanguage(pojoRepository.getLanguage());
            userRepository.setForks(pojoRepository.getForks());
            userRepository.setStars(pojoRepository.getStargazersCount());

        }
        return userRepository;
    }
}
