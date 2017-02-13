package com.example.app.testapp.domain.repository;

import com.example.app.testapp.data.entity.User;

import rx.Observable;

/**
 * Created by Tolik on 10.02.2017.
 */

public interface GitHubRepository {
    Observable<User> user(String username);
}
