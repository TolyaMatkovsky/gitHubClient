package com.example.app.testapp.presentation.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.app.testapp.presentation.MyApplication;
import com.example.app.testapp.presentation.internal.di.components.DaggerRepositoryComponent;
import com.example.app.testapp.presentation.internal.di.components.RepositoryComponent;
import com.example.app.testapp.presentation.internal.di.modules.ActivityModule;

import javax.inject.Inject;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

  private RepositoryComponent repositoryComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initializeRepositoryComponent();
    this.getRepositoryComponent().inject(this);
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  protected void initializeRepositoryComponent(){
    this.repositoryComponent = DaggerRepositoryComponent.builder()
            .applicationComponent(((MyApplication)getApplication()).getApplicationComponent())
            .build();
  }

  protected RepositoryComponent getRepositoryComponent(){
    return repositoryComponent;
  }
}
