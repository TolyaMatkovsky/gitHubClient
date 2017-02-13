package com.example.app.testapp.data.repository;

import android.graphics.Bitmap;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.entity.UserRepository;
import com.example.app.testapp.data.entity.mapper.UserDataMapper;
import com.example.app.testapp.data.entity.mapper.UserRepositoryDataMapper;
import com.example.app.testapp.data.manager.ImageSaveManager;
import com.example.app.testapp.domain.repository.GitHubRepository;
import com.example.app.testapp.data.pojo.GitHubUserRepository;
import com.example.app.testapp.data.pojo.GithubUser;
import com.example.app.testapp.data.repository.datasource.GitHubDataStore;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory;
import com.example.app.testapp.data.service.GitHubService;
import com.example.app.testapp.data.service.ServiceGenerator;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class GitHubDataRepository implements GitHubRepository {

    private GitHubDataStoreFactory factory;
    private UserDataMapper userDataMapper;
    private UserRepositoryDataMapper userRepositoryDataMapper;

    @Inject
    public GitHubDataRepository(GitHubDataStoreFactory factory, UserDataMapper userDataMapper, UserRepositoryDataMapper userRepositoryDataMapper) {
        this.factory = factory;
        this.userDataMapper = userDataMapper;
        this.userRepositoryDataMapper = userRepositoryDataMapper;
    }

    public GitHubDataRepository() {

    }

    @Override
    public Observable<User> user(String username) {
        final GitHubDataStore gitHubDataStore = factory.createCloudDataStore();
        return Observable.zip(gitHubDataStore.userGitHub(username), gitHubDataStore.userRepositories(username), new Func2<GithubUser, List<GitHubUserRepository>, User>() {
            @Override
            public User call(GithubUser githubUser, List<GitHubUserRepository> gitHubUserRepositories) {
                User user = userDataMapper.transform(githubUser);
                List<UserRepository> repositories = new ArrayList<UserRepository>();
                for (GitHubUserRepository g : gitHubUserRepositories) {
                    repositories.add(userRepositoryDataMapper.transform(g));
                }
                user.setRepositories(repositories);
                return user;
            }
        }).doOnNext(new Action1<User>() {
            @Override
            public void call(User user) {
                ServiceGenerator.createService(GitHubService.class).getImage(user.getAvatarURL())
                        .subscribe(new Subscriber<Bitmap>() {
                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Bitmap bitmap) {
                                String imageName = user.getName() + user.getId();
                                user.setAvatarURL(imageName);

                                ImageSaveManager.writeImage(bitmap, imageName);

                                user.setImageBitmap(bitmap);
                            }});
            }
        });
    }
}
