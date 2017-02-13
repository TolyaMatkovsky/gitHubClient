package com.example.app.testapp.data.repository.datasource;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GitHubDataStoreFactory_Factory implements Factory<GitHubDataStoreFactory> {
  private static final GitHubDataStoreFactory_Factory INSTANCE =
      new GitHubDataStoreFactory_Factory();

  @Override
  public GitHubDataStoreFactory get() {
    return new GitHubDataStoreFactory();
  }

  public static Factory<GitHubDataStoreFactory> create() {
    return INSTANCE;
  }
}
