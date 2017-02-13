package com.example.app.testapp.data.repository;

import android.content.Context;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivateUserDataRepository_MembersInjector
    implements MembersInjector<PrivateUserDataRepository> {
  private final Provider<Context> contextProvider;

  public PrivateUserDataRepository_MembersInjector(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  public static MembersInjector<PrivateUserDataRepository> create(
      Provider<Context> contextProvider) {
    return new PrivateUserDataRepository_MembersInjector(contextProvider);
  }

  @Override
  public void injectMembers(PrivateUserDataRepository instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.context = contextProvider.get();
  }

  public static void injectContext(
      PrivateUserDataRepository instance, Provider<Context> contextProvider) {
    instance.context = contextProvider.get();
  }
}
