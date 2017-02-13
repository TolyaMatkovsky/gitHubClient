package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.UpdateUserInterfaceThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvidePostExecutionThreadFactory
    implements Factory<PostExecutionThread> {
  private final ApplicationModule module;

  private final Provider<UpdateUserInterfaceThread> uiThreadProvider;

  public ApplicationModule_ProvidePostExecutionThreadFactory(
      ApplicationModule module, Provider<UpdateUserInterfaceThread> uiThreadProvider) {
    assert module != null;
    this.module = module;
    assert uiThreadProvider != null;
    this.uiThreadProvider = uiThreadProvider;
  }

  @Override
  public PostExecutionThread get() {
    return Preconditions.checkNotNull(
        module.providePostExecutionThread(uiThreadProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PostExecutionThread> create(
      ApplicationModule module, Provider<UpdateUserInterfaceThread> uiThreadProvider) {
    return new ApplicationModule_ProvidePostExecutionThreadFactory(module, uiThreadProvider);
  }

  /** Proxies {@link ApplicationModule#providePostExecutionThread(UpdateUserInterfaceThread)}. */
  public static PostExecutionThread proxyProvidePostExecutionThread(
      ApplicationModule instance, UpdateUserInterfaceThread uiThread) {
    return instance.providePostExecutionThread(uiThread);
  }
}
