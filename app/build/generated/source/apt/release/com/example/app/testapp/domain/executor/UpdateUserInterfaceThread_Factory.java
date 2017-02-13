package com.example.app.testapp.domain.executor;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateUserInterfaceThread_Factory implements Factory<UpdateUserInterfaceThread> {
  private static final UpdateUserInterfaceThread_Factory INSTANCE =
      new UpdateUserInterfaceThread_Factory();

  @Override
  public UpdateUserInterfaceThread get() {
    return new UpdateUserInterfaceThread();
  }

  public static Factory<UpdateUserInterfaceThread> create() {
    return INSTANCE;
  }
}
