package com.example.app.testapp.data.repository;

import dagger.internal.Factory;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RealmGitHubRepositoryImpl_Factory implements Factory<RealmGitHubRepositoryImpl> {
  private final Provider<Realm> realmProvider;

  public RealmGitHubRepositoryImpl_Factory(Provider<Realm> realmProvider) {
    assert realmProvider != null;
    this.realmProvider = realmProvider;
  }

  @Override
  public RealmGitHubRepositoryImpl get() {
    return new RealmGitHubRepositoryImpl(realmProvider.get());
  }

  public static Factory<RealmGitHubRepositoryImpl> create(Provider<Realm> realmProvider) {
    return new RealmGitHubRepositoryImpl_Factory(realmProvider);
  }
}
