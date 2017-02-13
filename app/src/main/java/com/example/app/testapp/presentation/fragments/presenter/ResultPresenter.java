package com.example.app.testapp.presentation.fragments.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.app.testapp.R;
import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.DefaultSubscriber;
import com.example.app.testapp.presentation.fragments.BaseFragment;
import com.example.app.testapp.presentation.fragments.views.ResultView;
import com.example.app.testapp.presentation.internal.di.PerFragment;
import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import javax.inject.Inject;

/**
 * Created by Tolik on 10.02.2017.
 */
@PerFragment
public class ResultPresenter implements Presenter {

    private ResultView view;
    private DBInteractor dbInteractor;
    private Context context;

    @Inject
    public ResultPresenter(DBInteractor dbInteractor, Context context) {
        this.dbInteractor = dbInteractor;
        this.context = context;
    }

    public void setView(@NonNull ResultView view) {
        this.view = view;
    }

    public void readUserFromDB(String userName){
        showViewLoading(context.getString(R.string.loading_data));
        dbInteractor.getUserByName(userName, new DBReadUserSubscriber());
    }

    public void deleteUserFromDB(String userName, DBInteractor.CallBack callBack){
        dbInteractor.deleteUserByName(userName, callBack);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        dbInteractor.unsubscribe();
        view = null;
    }

    private void showViewLoading(String message){
        this.view.showLoading(message);
    }

    private void hideViewLoading(){
        this.view.hideLoading();
    }

    private void showErrorMessage(String message){
        this.view.showError(message);
    }

    private void showResultInView(User user){
        this.view.renderUser(user);
    }

    @RxLogSubscriber
    private final class DBReadUserSubscriber extends DefaultSubscriber<User> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            ResultPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            e.printStackTrace();
            ResultPresenter.this.hideViewLoading();
            ResultPresenter.this.showErrorMessage(context.getResources().getString(R.string.homePresenterNetSubscriberError));
        }

        @Override
        public void onNext(User user) {
            super.onNext(user);
            ResultPresenter.this.showResultInView(user);
        }
    }
}
