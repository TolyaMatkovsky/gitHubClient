package com.example.app.testapp.presentation.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.testapp.R;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.GitHubUserInteractor;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl;
import com.example.app.testapp.presentation.activity.AppInterface;
import com.example.app.testapp.presentation.fragments.views.SearchFragView;
import com.example.app.testapp.presentation.internal.di.HasComponent;
import com.example.app.testapp.presentation.internal.di.components.DaggerGitHubUserComponent;
import com.example.app.testapp.presentation.internal.di.components.GitHubUserComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * Created by Tolik on 12.02.2017.
 */

public class SearchFragment extends BaseFragment implements SearchFragView, HasComponent<GitHubUserComponent> {

    @BindView(R.id.github_login)
    AppCompatEditText githubLogin;

    private AppInterface mainActivity;
    @Inject
    protected UserDataPresenter userDataPresenter;
    private Unbinder unbinder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (AppInterface) activity;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(GitHubUserComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        unbinder = ButterKnife.bind(this, view);

        userDataPresenter.setSaveUserInDB(true);

        return view;
    }

    @OnClick(R.id.home_look_up)
    public void lookUpUserInNet(){

        String gitHubLogin = githubLogin.getText().toString();
        userDataPresenter.checkAndGetUserByField(gitHubLogin);

    }

    @Override
    public void onResume() {
        super.onResume();
        githubLogin.setText("");

        mainActivity.setToolBarArrow(false);
        mainActivity.setDrawerSwipe(true);
        mainActivity.setToolBarTitle(getResString(R.string.search_user));

        userDataPresenter.setView(this);
        userDataPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        userDataPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        userDataPresenter.destroy();
        userDataPresenter = null;
    }

    @Override
    public void moveToResults(String userName) {
        mainActivity.moveToUserDataFragment(userName);
    }

    @Override
    public GitHubUserComponent getComponent() {
        return DaggerGitHubUserComponent.builder()
                .repositoryComponent(mainActivity.getReposComponent())
                .build();
    }
}
