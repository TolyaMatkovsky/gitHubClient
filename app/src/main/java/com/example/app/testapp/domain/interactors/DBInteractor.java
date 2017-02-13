package com.example.app.testapp.domain.interactors;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.domain.repository.DBGitHubRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tolik on 10.02.2017.
 */
public class DBInteractor {
    private DBGitHubRepository realmRepository;
    private CompositeSubscription compositeSubscription;

    @Inject
    public DBInteractor(DBGitHubRepository realmRepository) {
        this.realmRepository = realmRepository;
        this.compositeSubscription = new CompositeSubscription();
    }

    public interface CallBack{
        void success();
        void fail(Exception e);
    }

    @SuppressWarnings("unchecked")
    public void saveUser(User user, CallBack callBack){
        realmRepository.saveUser(user, callBack);
    }

    @SuppressWarnings("unchecked")
    public void getAllUsers(Subscriber subscriber){
        Subscription getAllSubscription = realmRepository.getAllUsers()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        compositeSubscription.add(getAllSubscription);
    }

    @SuppressWarnings("unchecked")
    public void getUserByName(String userName, Subscriber subscriber){
        Subscription getUserSubscription = realmRepository.getUserByName(userName)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        compositeSubscription.add(getUserSubscription);
    }

    public void deleteUserByName(String userName, CallBack callback){
        realmRepository.deleteUserByName(userName, callback);
    }

    public void unsubscribe() {
        if (!compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
        }
    }


}
