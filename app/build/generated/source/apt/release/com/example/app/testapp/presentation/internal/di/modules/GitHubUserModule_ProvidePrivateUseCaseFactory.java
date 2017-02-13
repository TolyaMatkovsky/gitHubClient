package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.interactors.UseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GitHubUserModule_ProvidePrivateUseCaseFactory implements Factory<UseCase> {
  private final GitHubUserModule module;

  private final Provider<PrivateUserDataRepository> privateUserDataRepositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GitHubUserModule_ProvidePrivateUseCaseFactory(
      GitHubUserModule module,
      Provider<PrivateUserDataRepository> privateUserDataRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    assert module != null;
    this.module = module;
    assert privateUserDataRepositoryProvider != null;
    this.privateUserDataRepositoryProvider = privateUserDataRepositoryProvider;
    assert threadExecutorProvider != null;
    this.threadExecutorProvider = threadExecutorProvider;
    assert postExecutionThreadProvider != null;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public UseCase get() {
    return Preconditions.checkNotNull(
        module.providePrivateUseCase(
            privateUserDataRepositoryProvider.get(),
            threadExecutorProvider.get(),
            postExecutionThreadProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UseCase> create(
      GitHubUserModule module,
      Provider<PrivateUserDataRepository> privateUserDataRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GitHubUserModule_ProvidePrivateUseCaseFactory(
        module,
        privateUserDataRepositoryProvider,
        threadExecutorProvider,
        postExecutionThreadProvider);
  }

  /**
   * Proxies {@link GitHubUserModule#providePrivateUseCase(PrivateUserDataRepository,
   * ThreadExecutor, PostExecutionThread)}.
   */
  public static UseCase proxyProvidePrivateUseCase(
      GitHubUserModule instance,
      PrivateUserDataRepository privateUserDataRepository,
      ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    return instance.providePrivateUseCase(
        privateUserDataRepository, threadExecutor, postExecutionThread);
  }
}
