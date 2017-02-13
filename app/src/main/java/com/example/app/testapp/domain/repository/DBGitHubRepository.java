package com.example.app.testapp.domain.repository;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.domain.interactors.DBInteractor;

import rx.Observable;

/**
 * Created by Tolik on 10.02.2017.
 */

public interface DBGitHubRepository {
    void saveUser(User user, DBInteractor.CallBack callBack);
    Observable<User> getAllUsers();
    Observable<User> getUserByName(String userName);
    void deleteUserByName(String userName, DBInteractor.CallBack callback);
}
