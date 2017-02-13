package com.example.app.testapp.data.repository;

import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.manager.ImageSaveManager;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.presentation.internal.di.RepositoryScope;
import com.fernandocejas.frodo.annotation.RxLogObservable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Tolik on 11.02.2017.
 */
@RepositoryScope
public class RealmGitHubRepositoryImpl implements DBGitHubRepository {

    private Realm realm;

    @Inject
    public RealmGitHubRepositoryImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    @RxLogObservable
    public void saveUser(User user, DBInteractor.CallBack callBack) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(user);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callBack.success();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callBack.fail((Exception) error);
            }
        });
    }

    @Override
    @RxLogObservable
    public Observable<User> getAllUsers() {
        return Observable.from(realm.where(User.class).findAllSorted("loginName"))
                .filter(new Func1<User, Boolean>() {
                    @Override
                    public Boolean call(User user) {
                        return user != null;
                    }
                }).doOnNext(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        user.setImageBitmap(ImageSaveManager.readImage(user.getAvatarURL()));
                    }
                });
    }

    @Override
    public Observable<User> getUserByName(String userName) {

        return realm.where(User.class).equalTo("loginName", userName).findFirstAsync()
                .asObservable()
                .filter(realmObject -> realmObject.isLoaded())
                .first()
                .flatMap(new Func1<RealmObject, Observable<User>>() {
                    @Override
                    public Observable<User> call(RealmObject realmObject) {
                        return Observable.just((User) realmObject);
                    }
                }).filter(new Func1<User, Boolean>() {
                    @Override
                    public Boolean call(User user) {
                        return user!=null;
                    }
                })
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        user.setImageBitmap(ImageSaveManager.readImage(user.getAvatarURL()));
                    }
                });
    }

    @Override
    public void deleteUserByName(String userName, DBInteractor.CallBack callBack) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.where(User.class).equalTo("loginName", userName).findFirst();
                user.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callBack.success();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callBack.fail((Exception) error);
            }
        });
    }
}









