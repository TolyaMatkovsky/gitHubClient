package com.example.app.testapp.data.repository;

import com.example.app.testapp.data.entity.mapper.PrivateUserDataMapper;
import com.example.app.testapp.data.entity.mapper.PrivateUserReposDataMapper;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivateUserDataRepository_Factory implements Factory<PrivateUserDataRepository> {
  private final MembersInjector<PrivateUserDataRepository> privateUserDataRepositoryMembersInjector;

  private final Provider<GitHubDataStoreFactory> factoryProvider;

  private final Provider<PrivateUserDataMapper> privateUserDataMapperProvider;

  private final Provider<PrivateUserReposDataMapper> privateUserReposDataMapperProvider;

  public PrivateUserDataRepository_Factory(
      MembersInjector<PrivateUserDataRepository> privateUserDataRepositoryMembersInjector,
      Provider<GitHubDataStoreFactory> factoryProvider,
      Provider<PrivateUserDataMapper> privateUserDataMapperProvider,
      Provider<PrivateUserReposDataMapper> privateUserReposDataMapperProvider) {
    assert privateUserDataRepositoryMembersInjector != null;
    this.privateUserDataRepositoryMembersInjector = privateUserDataRepositoryMembersInjector;
    assert factoryProvider != null;
    this.factoryProvider = factoryProvider;
    assert privateUserDataMapperProvider != null;
    this.privateUserDataMapperProvider = privateUserDataMapperProvider;
    assert privateUserReposDataMapperProvider != null;
    this.privateUserReposDataMapperProvider = privateUserReposDataMapperProvider;
  }

  @Override
  public PrivateUserDataRepository get() {
    return MembersInjectors.injectMembers(
        privateUserDataRepositoryMembersInjector,
        new PrivateUserDataRepository(
            factoryProvider.get(),
            privateUserDataMapperProvider.get(),
            privateUserReposDataMapperProvider.get()));
  }

  public static Factory<PrivateUserDataRepository> create(
      MembersInjector<PrivateUserDataRepository> privateUserDataRepositoryMembersInjector,
      Provider<GitHubDataStoreFactory> factoryProvider,
      Provider<PrivateUserDataMapper> privateUserDataMapperProvider,
      Provider<PrivateUserReposDataMapper> privateUserReposDataMapperProvider) {
    return new PrivateUserDataRepository_Factory(
        privateUserDataRepositoryMembersInjector,
        factoryProvider,
        privateUserDataMapperProvider,
        privateUserReposDataMapperProvider);
  }
}
