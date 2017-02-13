package com.example.app.testapp.presentation.fragments.presenter;

import com.example.app.testapp.domain.interactors.UseCase;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDataPresenter_MembersInjector implements MembersInjector<UserDataPresenter> {
  private final Provider<UseCase> cloudInteractorProvider;

  private final Provider<UseCase> privateCloudInteractorProvider;

  public UserDataPresenter_MembersInjector(
      Provider<UseCase> cloudInteractorProvider, Provider<UseCase> privateCloudInteractorProvider) {
    assert cloudInteractorProvider != null;
    this.cloudInteractorProvider = cloudInteractorProvider;
    assert privateCloudInteractorProvider != null;
    this.privateCloudInteractorProvider = privateCloudInteractorProvider;
  }

  public static MembersInjector<UserDataPresenter> create(
      Provider<UseCase> cloudInteractorProvider, Provider<UseCase> privateCloudInteractorProvider) {
    return new UserDataPresenter_MembersInjector(
        cloudInteractorProvider, privateCloudInteractorProvider);
  }

  @Override
  public void injectMembers(UserDataPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.cloudInteractor = cloudInteractorProvider.get();
    instance.privateCloudInteractor = privateCloudInteractorProvider.get();
  }

  public static void injectCloudInteractor(
      UserDataPresenter instance, Provider<UseCase> cloudInteractorProvider) {
    instance.cloudInteractor = cloudInteractorProvider.get();
  }

  public static void injectPrivateCloudInteractor(
      UserDataPresenter instance, Provider<UseCase> privateCloudInteractorProvider) {
    instance.privateCloudInteractor = privateCloudInteractorProvider.get();
  }
}
