package com.example.app.testapp.data.entity.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PrivateUserDataMapper_Factory implements Factory<PrivateUserDataMapper> {
  private static final PrivateUserDataMapper_Factory INSTANCE = new PrivateUserDataMapper_Factory();

  @Override
  public PrivateUserDataMapper get() {
    return new PrivateUserDataMapper();
  }

  public static Factory<PrivateUserDataMapper> create() {
    return INSTANCE;
  }
}
