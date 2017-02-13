package com.example.app.testapp.presentation.fragments.presenter;

import android.content.Context;
import com.example.app.testapp.domain.interactors.DBInteractor;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDataPresenter_Factory implements Factory<UserDataPresenter> {
  private final MembersInjector<UserDataPresenter> userDataPresenterMembersInjector;

  private final Provider<DBInteractor> dbInteractorProvider;

  private final Provider<Context> contextProvider;

  public UserDataPresenter_Factory(
      MembersInjector<UserDataPresenter> userDataPresenterMembersInjector,
      Provider<DBInteractor> dbInteractorProvider,
      Provider<Context> contextProvider) {
    assert userDataPresenterMembersInjector != null;
    this.userDataPresenterMembersInjector = userDataPresenterMembersInjector;
    assert dbInteractorProvider != null;
    this.dbInteractorProvider = dbInteractorProvider;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public UserDataPresenter get() {
    return MembersInjectors.injectMembers(
        userDataPresenterMembersInjector,
        new UserDataPresenter(dbInteractorProvider.get(), contextProvider.get()));
  }

  public static Factory<UserDataPresenter> create(
      MembersInjector<UserDataPresenter> userDataPresenterMembersInjector,
      Provider<DBInteractor> dbInteractorProvider,
      Provider<Context> contextProvider) {
    return new UserDataPresenter_Factory(
        userDataPresenterMembersInjector, dbInteractorProvider, contextProvider);
  }
}
