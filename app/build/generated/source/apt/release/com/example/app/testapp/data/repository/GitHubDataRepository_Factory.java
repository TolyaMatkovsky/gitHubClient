package com.example.app.testapp.data.repository;

import com.example.app.testapp.data.entity.mapper.UserDataMapper;
import com.example.app.testapp.data.entity.mapper.UserRepositoryDataMapper;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GitHubDataRepository_Factory implements Factory<GitHubDataRepository> {
  private final Provider<GitHubDataStoreFactory> factoryProvider;

  private final Provider<UserDataMapper> userDataMapperProvider;

  private final Provider<UserRepositoryDataMapper> userRepositoryDataMapperProvider;

  public GitHubDataRepository_Factory(
      Provider<GitHubDataStoreFactory> factoryProvider,
      Provider<UserDataMapper> userDataMapperProvider,
      Provider<UserRepositoryDataMapper> userRepositoryDataMapperProvider) {
    assert factoryProvider != null;
    this.factoryProvider = factoryProvider;
    assert userDataMapperProvider != null;
    this.userDataMapperProvider = userDataMapperProvider;
    assert userRepositoryDataMapperProvider != null;
    this.userRepositoryDataMapperProvider = userRepositoryDataMapperProvider;
  }

  @Override
  public GitHubDataRepository get() {
    return new GitHubDataRepository(
        factoryProvider.get(),
        userDataMapperProvider.get(),
        userRepositoryDataMapperProvider.get());
  }

  public static Factory<GitHubDataRepository> create(
      Provider<GitHubDataStoreFactory> factoryProvider,
      Provider<UserDataMapper> userDataMapperProvider,
      Provider<UserRepositoryDataMapper> userRepositoryDataMapperProvider) {
    return new GitHubDataRepository_Factory(
        factoryProvider, userDataMapperProvider, userRepositoryDataMapperProvider);
  }
}
