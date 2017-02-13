package com.example.app.testapp.presentation.internal.di.modules;

import com.example.app.testapp.data.repository.GitHubDataRepository;
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
public final class GitHubUserModule_ProvideAllUseCaseFactory implements Factory<UseCase> {
  private final GitHubUserModule module;

  private final Provider<GitHubDataRepository> gitHubDataRepositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GitHubUserModule_ProvideAllUseCaseFactory(
      GitHubUserModule module,
      Provider<GitHubDataRepository> gitHubDataRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    assert module != null;
    this.module = module;
    assert gitHubDataRepositoryProvider != null;
    this.gitHubDataRepositoryProvider = gitHubDataRepositoryProvider;
    assert threadExecutorProvider != null;
    this.threadExecutorProvider = threadExecutorProvider;
    assert postExecutionThreadProvider != null;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public UseCase get() {
    return Preconditions.checkNotNull(
        module.provideAllUseCase(
            gitHubDataRepositoryProvider.get(),
            threadExecutorProvider.get(),
            postExecutionThreadProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UseCase> create(
      GitHubUserModule module,
      Provider<GitHubDataRepository> gitHubDataRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GitHubUserModule_ProvideAllUseCaseFactory(
        module, gitHubDataRepositoryProvider, threadExecutorProvider, postExecutionThreadProvider);
  }

  /**
   * Proxies {@link GitHubUserModule#provideAllUseCase(GitHubDataRepository, ThreadExecutor,
   * PostExecutionThread)}.
   */
  public static UseCase proxyProvideAllUseCase(
      GitHubUserModule instance,
      GitHubDataRepository gitHubDataRepository,
      ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    return instance.provideAllUseCase(gitHubDataRepository, threadExecutor, postExecutionThread);
  }
}
