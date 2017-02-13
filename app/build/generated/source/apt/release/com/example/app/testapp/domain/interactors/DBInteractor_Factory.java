package com.example.app.testapp.domain.interactors;

import com.example.app.testapp.domain.repository.DBGitHubRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBInteractor_Factory implements Factory<DBInteractor> {
  private final Provider<DBGitHubRepository> realmRepositoryProvider;

  public DBInteractor_Factory(Provider<DBGitHubRepository> realmRepositoryProvider) {
    assert realmRepositoryProvider != null;
    this.realmRepositoryProvider = realmRepositoryProvider;
  }

  @Override
  public DBInteractor get() {
    return new DBInteractor(realmRepositoryProvider.get());
  }

  public static Factory<DBInteractor> create(Provider<DBGitHubRepository> realmRepositoryProvider) {
    return new DBInteractor_Factory(realmRepositoryProvider);
  }
}
