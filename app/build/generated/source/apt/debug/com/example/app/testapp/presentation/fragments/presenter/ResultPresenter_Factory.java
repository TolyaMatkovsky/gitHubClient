package com.example.app.testapp.presentation.fragments.presenter;

import android.content.Context;
import com.example.app.testapp.domain.interactors.DBInteractor;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ResultPresenter_Factory implements Factory<ResultPresenter> {
  private final Provider<DBInteractor> dbInteractorProvider;

  private final Provider<Context> contextProvider;

  public ResultPresenter_Factory(
      Provider<DBInteractor> dbInteractorProvider, Provider<Context> contextProvider) {
    assert dbInteractorProvider != null;
    this.dbInteractorProvider = dbInteractorProvider;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public ResultPresenter get() {
    return new ResultPresenter(dbInteractorProvider.get(), contextProvider.get());
  }

  public static Factory<ResultPresenter> create(
      Provider<DBInteractor> dbInteractorProvider, Provider<Context> contextProvider) {
    return new ResultPresenter_Factory(dbInteractorProvider, contextProvider);
  }
}
