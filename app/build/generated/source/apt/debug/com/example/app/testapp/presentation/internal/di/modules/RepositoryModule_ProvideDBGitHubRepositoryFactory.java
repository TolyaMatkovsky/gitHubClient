package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RepositoryModule_ProvideDBGitHubRepositoryFactory
    implements Factory<DBGitHubRepository> {
  private final RepositoryModule module;

  private final Provider<RealmGitHubRepositoryImpl> realmGitHubRepositoryProvider;

  public RepositoryModule_ProvideDBGitHubRepositoryFactory(
      RepositoryModule module, Provider<RealmGitHubRepositoryImpl> realmGitHubRepositoryProvider) {
    assert module != null;
    this.module = module;
    assert realmGitHubRepositoryProvider != null;
    this.realmGitHubRepositoryProvider = realmGitHubRepositoryProvider;
  }

  @Override
  public DBGitHubRepository get() {
    return Preconditions.checkNotNull(
        module.provideDBGitHubRepository(realmGitHubRepositoryProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DBGitHubRepository> create(
      RepositoryModule module, Provider<RealmGitHubRepositoryImpl> realmGitHubRepositoryProvider) {
    return new RepositoryModule_ProvideDBGitHubRepositoryFactory(
        module, realmGitHubRepositoryProvider);
  }

  /** Proxies {@link RepositoryModule#provideDBGitHubRepository(RealmGitHubRepositoryImpl)}. */
  public static DBGitHubRepository proxyProvideDBGitHubRepository(
      RepositoryModule instance, RealmGitHubRepositoryImpl realmGitHubRepository) {
    return instance.provideDBGitHubRepository(realmGitHubRepository);
  }
}
