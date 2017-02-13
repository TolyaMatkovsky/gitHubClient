package com.example.app.testapp.data.entity.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDataMapper_Factory implements Factory<UserDataMapper> {
  private static final UserDataMapper_Factory INSTANCE = new UserDataMapper_Factory();

  @Override
  public UserDataMapper get() {
    return new UserDataMapper();
  }

  public static Factory<UserDataMapper> create() {
    return INSTANCE;
  }
}
