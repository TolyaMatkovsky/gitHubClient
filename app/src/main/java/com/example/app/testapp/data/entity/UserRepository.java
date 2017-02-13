package com.example.app.testapp.data.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Tolik on 11.02.2017.
 */
public class UserRepository extends RealmObject{
    @PrimaryKey
    private int id;

    private String language;
    private String repositoryTitle;
    private int forks;
    private int stars;

    public UserRepository() {
    }

    public UserRepository(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRepositoryTitle() {
        return repositoryTitle;
    }

    public void setRepositoryTitle(String repositoryTitle) {
        this.repositoryTitle = repositoryTitle;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", repositoryTitle='" + repositoryTitle + '\'' +
                ", forks=" + forks +
                ", stars=" + stars +
                '}';
    }
}
