package com.example.app.testapp.data.entity;

import android.graphics.Bitmap;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Tolik on 11.02.2017.
 */
public class User extends RealmObject{

    @PrimaryKey
    private int id;
    @Ignore
    private Bitmap imageBitmap;
    @Required
    private String loginName;
    private String name;
    private String email;
    private String company;
    private String avatarURL;
    private String htmlURL;
    private int followers;
    private int following;
    private int publicGists;
    private int publicRepos;

    private RealmList<UserRepository> repositories;

    public User() {
    }

    public User(int userID) {
        this.id = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    public String getName() {
        return name;
    }

    public List<UserRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<UserRepository> repositories) {
        this.repositories = new RealmList<>((UserRepository[]) repositories.toArray(new UserRepository[repositories.size()]));
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", imageBitmap=" + imageBitmap +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                ", htmlURL='" + htmlURL + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", publicGists=" + publicGists +
                ", publicRepos=" + publicRepos +
                ", repositories=" + repositories +
                '}';
    }
}
