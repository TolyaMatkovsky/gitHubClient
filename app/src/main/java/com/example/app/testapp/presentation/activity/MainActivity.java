package com.example.app.testapp.presentation.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.testapp.R;
import com.example.app.testapp.data.manager.AlertManager;
import com.example.app.testapp.data.manager.SettingsManager;
import com.example.app.testapp.data.manager.ToolsManager;
import com.example.app.testapp.presentation.fragments.SearchFragment;
import com.example.app.testapp.presentation.fragments.UserDataFragment;
import com.example.app.testapp.presentation.internal.di.components.ApplicationComponent;
import com.example.app.testapp.presentation.internal.di.components.RepositoryComponent;
import com.example.app.testapp.presentation.internal.di.modules.ActivityModule;

import java.util.Stack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.app.testapp.presentation.fragments.FragmentKeyArguments.*;
/**
 * Created by Tolik on 11.02.2016.
 */

public class MainActivity extends BaseActivity implements AppInterface {

    @BindView(R.id.toolbar_title)
    TextView title;
    @BindView(R.id.toolbar_left_button)
    ImageView toolBarLeftButton;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;


    private FragmentManager fragmentManager;
    private Fragment userDataFragment, searchFragment;
    private Stack<Fragment> fragmentStack;
    private Unbinder unbinder;
    private SettingsManager settingsManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        settingsManager = SettingsManager.getInstance(this);
        settingsManager.setUserLogout(false);
        settingsManager.save();

        fragmentManager = getSupportFragmentManager();
        fragmentStack = new Stack<>();

        userDataFragment = new UserDataFragment();
        searchFragment = new SearchFragment();

        initDrawer();
        initialize();

    }

    @Override
    public void setToolBarTitle(String title) {
        this.title.setText(title);
    }



    @Override
    public void setToolBarLeftButtonListener(View.OnClickListener listener) {
        toolBarLeftButton.setOnClickListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setDrawerSwipe(true);
        setToolBarArrow(false);

    }

    private void initDrawer() {

        navigationView.setCheckedItem(R.id.user_data);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.user_data:
                        menuItem.setChecked(true);
                        if (fragmentStack.size() != 0) {
                            if (!(fragmentStack.lastElement() instanceof UserDataFragment)) {
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                                Bundle args = new Bundle();
                                args.putBoolean(KEY_OWN_USER_DATA, true);
                                userDataFragment.setArguments(args);

                                fragmentTransaction.replace(R.id.root, userDataFragment);

                                fragmentStack.removeAllElements();
                                fragmentStack.push(userDataFragment);

                                fragmentTransaction.commit();
                            }
                        }
                        return true;

                    case R.id.look_up:
                        menuItem.setChecked(true);
                            if (!(fragmentStack.lastElement() instanceof SearchFragment)) {
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.root, searchFragment);
                                fragmentStack.removeAllElements();
                                fragmentStack.push(searchFragment);
                                fragmentTransaction.commit();
                            }
                        return true;

                    case R.id.logout:
                        logoutDialog();

                        return true;

                    default:
                        AlertManager.showToast(getApplicationContext(), getString(R.string.something_wrong));
                        return true;
                }
            }
        });
    }

    private void initialize(){
        setDrawerSwipe(true);
        setToolBarArrow(false);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle args = new Bundle();
        args.putBoolean(KEY_OWN_USER_DATA, true);
        userDataFragment.setArguments(args);

        fragmentTransaction.replace(R.id.root, userDataFragment);
        fragmentStack.push(userDataFragment);
        fragmentTransaction.commit();
    }

    public void toggleMenu() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            ToolsManager.hideKeyboard(this);
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public void setDrawerSwipe(boolean swipe) {
        if (swipe){
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        } else {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    @Override
    public void setToolBarArrow(boolean arrow) {
        if ( arrow ) {
            toolBarLeftButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_arrow_back));
            toolBarLeftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            toolBarLeftButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_menu));
            toolBarLeftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleMenu();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if ( drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder != null){
            unbinder.unbind();
        }
    }

    private void logoutDialog() {
        final Dialog dialog = new Dialog(this, R.style.Base_Theme_AppCompat_Dialog);
                     dialog.setContentView(R.layout.dialog_logout);

        Button dialogCancel = (Button) dialog.findViewById(R.id.dialogButtonCancel);
        Button dialogOk = (Button) dialog.findViewById(R.id.dialogButtonOK);

        dialogOk.setOnClickListener(v -> {
            settingsManager.setUserLogout(true);
            settingsManager.save();

            Intent logout = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(logout);
            MainActivity.this.finish();
        });
        dialogCancel.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    @Override
    public void moveToUserDataFragment(String userName) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle args = new Bundle();
        args.putBoolean(KEY_OWN_USER_DATA, false);
        args.putString(KEY_GIT_HUB_SEARCH, userName);
        userDataFragment.setArguments(args);

        fragmentTransaction.replace(R.id.root, userDataFragment);
        fragmentStack.push(userDataFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void backToSearchFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.root, searchFragment);
        fragmentStack.removeAllElements();
        fragmentStack.push(searchFragment);
        fragmentTransaction.commit();
    }

    @Override
    public RepositoryComponent getReposComponent() {
        return getRepositoryComponent();
    }
}
