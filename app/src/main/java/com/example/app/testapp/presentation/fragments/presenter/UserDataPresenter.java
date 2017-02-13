package com.example.app.testapp.presentation.fragments.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.app.testapp.R;
import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.DefaultSubscriber;
import com.example.app.testapp.domain.interactors.UseCase;
import com.example.app.testapp.data.manager.ToolsManager;
import com.example.app.testapp.presentation.fragments.BaseFragment;
import com.example.app.testapp.presentation.fragments.UserDataFragment;
import com.example.app.testapp.presentation.fragments.views.DataView;
import com.example.app.testapp.presentation.fragments.views.ResultView;
import com.example.app.testapp.presentation.fragments.views.SearchFragView;
import com.example.app.testapp.presentation.internal.di.PerFragment;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tolik on 10.02.2017.
 */
@PerFragment
public class UserDataPresenter implements Presenter {

    private DataView view;
    @Inject
    @Named("all")
    protected UseCase cloudInteractor;
    @Inject
    @Named("private")
    protected UseCase privateCloudInteractor;
    private DBInteractor dbInteractor;
    private Context context;
    private boolean saveUserInDB;
    private ResultView resultView;
    private SearchFragView searchFragView;
    private String userName;

    @Inject
    public UserDataPresenter(DBInteractor dbInteractor, Context context) {
        this.dbInteractor = dbInteractor;
        this.context = context;
    }

    public void setSaveUserInDB(boolean saveUserInDB) {
        this.saveUserInDB = saveUserInDB;
    }

    public void setView(@NonNull ResultView view) {
        this.view = view;
    }

    public void setView(@NonNull SearchFragView view) {
        this.view = view;
    }

    @Override
    public void resume() {
        if(this.view instanceof ResultView){
            resultView = (ResultView) view;
        }else if(this.view instanceof SearchFragView){
            searchFragView = (SearchFragView) view;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        if(saveUserInDB){
            cloudInteractor.unsubscribe();
            dbInteractor.unsubscribe();
        }else {
            privateCloudInteractor.unsubscribe();
        }
        view = null;
    }

    private boolean checkInternet(){
        return ToolsManager.checkWifiOrMobileInternet(context);
    }

    private void getGitHubUserFromNet(String userName) {
        this.userName = userName;

        if(saveUserInDB){
            cloudInteractor.setUserName(userName);
            cloudInteractor.execute(new UserFromNetInDBSubscriber());
        }else {
            privateCloudInteractor.setUserName(userName);
            privateCloudInteractor.execute(new UserFromNetSubscriber());
        }
    }

    public void checkAndGetUserByField(String userName) {
        if (userName.trim().isEmpty()) {
            this.view.showError(context.getResources().getString(R.string.homeActEnterFieldError));
        } else {
            if(checkInternet()){
                showViewLoading(context.getString(R.string.loading_data));
                getGitHubUserFromNet(userName);
            }else {
                this.view.showInternetDisconnectMessage();
            }

        }
    }

    private void showResultInView(){
        this.searchFragView.moveToResults(this.userName);
    }

    private void showViewLoading(String message) {
        this.view.showLoading(message);
    }

    private void hideViewLoading() {
        this.view.hideLoading();
    }

    private void showErrorMessage(String message) {
        this.view.showError(message);
    }

    private void showResultInView(User user){
        this.resultView.renderUser(user);
    }

    private final class UserFromNetSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onCompleted() {
            UserDataPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            UserDataPresenter.this.hideViewLoading();
            UserDataPresenter.this.showErrorMessage(context.getResources().getString(R.string.homePresenterNetSubscriberError));
        }

        @Override
        public void onNext(User user) {
            UserDataPresenter.this.showResultInView(user);
        }
    }

    private final class UserFromNetInDBSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onCompleted() {
            UserDataPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            UserDataPresenter.this.hideViewLoading();
            UserDataPresenter.this.showErrorMessage(context.getResources().getString(R.string.homePresenterNetSubscriberError));
        }

        @Override
        public void onNext(User user) {

            dbInteractor.saveUser(user, new DBInteractor.CallBack() {
                @Override
                public void success() {
                    UserDataPresenter.this.hideViewLoading();
                    UserDataPresenter.this.showResultInView();
                }

                @Override
                public void fail(Exception e) {
                    e.printStackTrace();
                    UserDataPresenter.this.hideViewLoading();
                    UserDataPresenter.this.showErrorMessage(context.getResources().getString(R.string.homePresenterNetSubscriberError));
                }
            });
        }
    }
}
