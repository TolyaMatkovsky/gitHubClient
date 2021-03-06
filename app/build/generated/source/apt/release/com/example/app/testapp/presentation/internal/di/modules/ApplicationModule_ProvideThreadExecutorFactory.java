package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.data.executor.JobExecutor;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideThreadExecutorFactory
    implements Factory<ThreadExecutor> {
  private final ApplicationModule module;

  private final Provider<JobExecutor> jobExecutorProvider;

  public ApplicationModule_ProvideThreadExecutorFactory(
      ApplicationModule module, Provider<JobExecutor> jobExecutorProvider) {
    assert module != null;
    this.module = module;
    assert jobExecutorProvider != null;
    this.jobExecutorProvider = jobExecutorProvider;
  }

  @Override
  public ThreadExecutor get() {
    return Preconditions.checkNotNull(
        module.provideThreadExecutor(jobExecutorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ThreadExecutor> create(
      ApplicationModule module, Provider<JobExecutor> jobExecutorProvider) {
    return new ApplicationModule_ProvideThreadExecutorFactory(module, jobExecutorProvider);
  }

  /** Proxies {@link ApplicationModule#provideThreadExecutor(JobExecutor)}. */
  public static ThreadExecutor proxyProvideThreadExecutor(
      ApplicationModule instance, JobExecutor jobExecutor) {
    return instance.provideThreadExecutor(jobExecutor);
  }
}
