package com.example.app.testapp.data.entity.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserRepositoryDataMapper_Factory implements Factory<UserRepositoryDataMapper> {
  private static final UserRepositoryDataMapper_Factory INSTANCE =
      new UserRepositoryDataMapper_Factory();

  @Override
  public UserRepositoryDataMapper get() {
    return new UserRepositoryDataMapper();
  }

  public static Factory<UserRepositoryDataMapper> create() {
    return INSTANCE;
  }
}
