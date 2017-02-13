package com.example.app.testapp.data.repository;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.entity.UserRepository;
import com.example.app.testapp.data.entity.mapper.PrivateUserDataMapper;
import com.example.app.testapp.data.entity.mapper.PrivateUserReposDataMapper;
import com.example.app.testapp.data.manager.ImageSaveManager;
import com.example.app.testapp.data.manager.SettingsManager;
import com.example.app.testapp.data.repository.datasource.GitHubDataStore;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory;
import com.example.app.testapp.domain.repository.GitHubRepository;
import com.example.app.testapp.data.pojo.PrivateUser;
import com.example.app.testapp.data.pojo.PrivateUserRepos;
import com.example.app.testapp.data.service.AccessToken;
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
public class PrivateUserDataRepository  implements GitHubRepository {
    @Inject
    Context context;
    private GitHubDataStoreFactory factory;
    private PrivateUserDataMapper privateUserDataMapper;
    private PrivateUserReposDataMapper privateUserReposDataMapper;
    private AccessToken accessToken;

    @Inject
    public PrivateUserDataRepository(GitHubDataStoreFactory factory, PrivateUserDataMapper privateUserDataMapper, PrivateUserReposDataMapper privateUserReposDataMapper) {
        this.factory = factory;
        this.privateUserDataMapper = privateUserDataMapper;
        this.privateUserReposDataMapper = privateUserReposDataMapper;
    }

    public PrivateUserDataRepository() {
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Observable<User> user(String username) {
        AccessToken accessToken = SettingsManager.getInstance(context).getAccessToken();

        final GitHubDataStore gitHubDataStore = factory.createCloudDataStore(accessToken);
        return Observable.zip(gitHubDataStore.privateUser(), gitHubDataStore.privateUserRepos(), new Func2<PrivateUser, List<PrivateUserRepos>, User>() {
            @Override
            public User call(PrivateUser privateUser, List<PrivateUserRepos> privateUserReposes) {
                User user = privateUserDataMapper.transform(privateUser);
                List<UserRepository> repositories = new ArrayList<UserRepository>();
                for (PrivateUserRepos g : privateUserReposes) {
                    repositories.add(privateUserReposDataMapper.transform(g));
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