package com.example.app.testapp.data.entity.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivateUserReposDataMapper_Factory
    implements Factory<PrivateUserReposDataMapper> {
  private static final PrivateUserReposDataMapper_Factory INSTANCE =
      new PrivateUserReposDataMapper_Factory();

  @Override
  public PrivateUserReposDataMapper get() {
    return new PrivateUserReposDataMapper();
  }

  public static Factory<PrivateUserReposDataMapper> create() {
    return INSTANCE;
  }
}
