package com.example.app.testapp.presentation.fragments;

import com.example.app.testapp.presentation.fragments.presenter.ResultPresenter;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDataFragment_MembersInjector implements MembersInjector<UserDataFragment> {
  private final Provider<ResultPresenter> resultPresenterProvider;

  private final Provider<UserDataPresenter> userDataPresenterProvider;

  public UserDataFragment_MembersInjector(
      Provider<ResultPresenter> resultPresenterProvider,
      Provider<UserDataPresenter> userDataPresenterProvider) {
    assert resultPresenterProvider != null;
    this.resultPresenterProvider = resultPresenterProvider;
    assert userDataPresenterProvider != null;
    this.userDataPresenterProvider = userDataPresenterProvider;
  }

  public static MembersInjector<UserDataFragment> create(
      Provider<ResultPresenter> resultPresenterProvider,
      Provider<UserDataPresenter> userDataPresenterProvider) {
    return new UserDataFragment_MembersInjector(resultPresenterProvider, userDataPresenterProvider);
  }

  @Override
  public void injectMembers(UserDataFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.resultPresenter = resultPresenterProvider.get();
    instance.userDataPresenter = userDataPresenterProvider.get();
  }

  public static void injectResultPresenter(
      UserDataFragment instance, Provider<ResultPresenter> resultPresenterProvider) {
    instance.resultPresenter = resultPresenterProvider.get();
  }

  public static void injectUserDataPresenter(
      UserDataFragment instance, Provider<UserDataPresenter> userDataPresenterProvider) {
    instance.userDataPresenter = userDataPresenterProvider.get();
  }
}
