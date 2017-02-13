package com.example.app.testapp.presentation.activity;

import android.view.View;

import com.example.app.testapp.presentation.internal.di.components.ApplicationComponent;
import com.example.app.testapp.presentation.internal.di.components.RepositoryComponent;
import com.example.app.testapp.presentation.internal.di.modules.ActivityModule;

/**
 * Created by Tolik on 11.02.2016.
 */

public interface AppInterface {
    void setToolBarTitle(String title);
    void setToolBarLeftButtonListener(View.OnClickListener listener);
    void onBackPressed();
    void setToolBarArrow(boolean arrow);
    void setDrawerSwipe(boolean swipe);
    void moveToUserDataFragment(String userName);
    void backToSearchFragment();

    RepositoryComponent getReposComponent();
}
