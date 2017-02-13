package com.example.app.testapp.presentation.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.testapp.R;
import com.example.app.testapp.presentation.adapters.ReposAdapter;
import com.example.app.testapp.data.entity.User;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.GitHubUserInteractor;
import com.example.app.testapp.data.manager.SettingsManager;
import com.example.app.testapp.presentation.fragments.presenter.Presenter;
import com.example.app.testapp.presentation.fragments.presenter.ResultPresenter;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl;
import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.presentation.activity.AppInterface;
import com.example.app.testapp.presentation.fragments.views.ResultView;
import com.example.app.testapp.presentation.internal.di.HasComponent;
import com.example.app.testapp.presentation.internal.di.components.DaggerGitHubUserComponent;
import com.example.app.testapp.presentation.internal.di.components.GitHubUserComponent;
import com.example.app.testapp.presentation.internal.di.modules.GitHubUserModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;

import static com.example.app.testapp.presentation.fragments.FragmentKeyArguments.*;
/**
 * Created by Tolik on 11.02.2017.
 */

public class UserDataFragment  extends BaseFragment implements ResultView, HasComponent<GitHubUserComponent>{

    @BindView(R.id.user_photo)
    ImageView userPhoto;
    @BindView(R.id.results_recycle_view)
    RecyclerView recyclerView;
    @BindView(R.id.results_followers_count)
    TextView followers;
    @BindView(R.id.results_following_count)
    TextView following;
    @BindView(R.id.results_gists)
    TextView gists;
    @BindView(R.id.results_repos)
    TextView repos;
    @BindView(R.id.name)
    TextView reposName;

    private AppInterface mainActivity;
    @Inject
    protected ResultPresenter resultPresenter;
    @Inject
    protected UserDataPresenter userDataPresenter;
    private Unbinder unbinder;
    private ReposAdapter reposAdapter;
    private Presenter presenter;
    private SettingsManager settingsManager;
    private boolean isNewData;

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
        View view = inflater.inflate(R.layout.fragment_user_data, container, false);

        unbinder = ButterKnife.bind(this, view);

        settingsManager = SettingsManager.getInstance((Context) mainActivity);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((Context) mainActivity);
        recyclerView.setLayoutManager(layoutManager);
        reposAdapter = new ReposAdapter((Context) mainActivity);
        recyclerView.setAdapter(reposAdapter);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        isNewData = getArguments().getBoolean(KEY_OWN_USER_DATA);
        if(isNewData){
            mainActivity.setToolBarArrow(false);
            mainActivity.setDrawerSwipe(true);
            mainActivity.setToolBarTitle(getResString(R.string.user_data));

            AccessToken accessToken = settingsManager.getAccessToken();

            userDataPresenter.setSaveUserInDB(false);
            userDataPresenter.setView(this);

            presenter = userDataPresenter;
            presenter.resume();

            userDataPresenter.checkAndGetUserByField("PrivateUser");
        }else {
            String gitHubLogin = getArguments().getString(KEY_GIT_HUB_SEARCH);
            mainActivity.setToolBarArrow(true);
            mainActivity.setToolBarLeftButtonListener(v -> {
                mainActivity.backToSearchFragment();
            });
            mainActivity.setDrawerSwipe(false);
            mainActivity.setToolBarTitle(getResString(R.string.search) + gitHubLogin);

            resultPresenter.setView(this);
            presenter = resultPresenter;
            presenter.resume();

            resultPresenter.readUserFromDB(gitHubLogin);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        presenter.destroy();
        presenter = null;
    }

    @Override
    public void renderUser(User user) {
        userPhoto.setImageBitmap(user.getImageBitmap());
        followers.setText(String.valueOf(user.getFollowers()));
        following.setText(String.valueOf(user.getFollowing()));
        gists.setText(String.valueOf(user.getPublicGists()));
        repos.setText(String.valueOf(user.getPublicRepos()));
        reposName.setText(String.valueOf(user.getName()));

        mainActivity.setToolBarTitle(user.getLoginName());

        reposAdapter.setReposCollection(user.getRepositories());

    }

    @Override
    public GitHubUserComponent getComponent() {
        return DaggerGitHubUserComponent.builder()
                .repositoryComponent(mainActivity.getReposComponent())
                .build();
    }
}
