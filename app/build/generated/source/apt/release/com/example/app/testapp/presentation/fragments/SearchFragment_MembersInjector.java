package com.example.app.testapp.presentation.fragments;

import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
  private final Provider<UserDataPresenter> userDataPresenterProvider;

  public SearchFragment_MembersInjector(Provider<UserDataPresenter> userDataPresenterProvider) {
    assert userDataPresenterProvider != null;
    this.userDataPresenterProvider = userDataPresenterProvider;
  }

  public static MembersInjector<SearchFragment> create(
      Provider<UserDataPresenter> userDataPresenterProvider) {
    return new SearchFragment_MembersInjector(userDataPresenterProvider);
  }

  @Override
  public void injectMembers(SearchFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.userDataPresenter = userDataPresenterProvider.get();
  }

  public static void injectUserDataPresenter(
      SearchFragment instance, Provider<UserDataPresenter> userDataPresenterProvider) {
    instance.userDataPresenter = userDataPresenterProvider.get();
  }
}
