package com.example.app.testapp.presentation.internal.di.components;

import android.content.Context;
import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.interactors.DBInteractor;
import com.example.app.testapp.domain.interactors.DBInteractor_Factory;
import com.example.app.testapp.domain.interactors.UseCase;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.presentation.fragments.SearchFragment;
import com.example.app.testapp.presentation.fragments.SearchFragment_MembersInjector;
import com.example.app.testapp.presentation.fragments.UserDataFragment;
import com.example.app.testapp.presentation.fragments.UserDataFragment_MembersInjector;
import com.example.app.testapp.presentation.fragments.presenter.ResultPresenter;
import com.example.app.testapp.presentation.fragments.presenter.ResultPresenter_Factory;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter_Factory;
import com.example.app.testapp.presentation.fragments.presenter.UserDataPresenter_MembersInjector;
import com.example.app.testapp.presentation.internal.di.modules.GitHubUserModule;
import com.example.app.testapp.presentation.internal.di.modules.GitHubUserModule_ProvideAllUseCaseFactory;
import com.example.app.testapp.presentation.internal.di.modules.GitHubUserModule_ProvidePrivateUseCaseFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerGitHubUserComponent implements GitHubUserComponent {
  private Provider<DBGitHubRepository> provideDBRepositoryProvider;

  private Provider<DBInteractor> dBInteractorProvider;

  private Provider<Context> provideContextProvider;

  private Provider<ResultPresenter> resultPresenterProvider;

  private Provider<GitHubDataRepository> provideRepositoryProvider;

  private Provider<ThreadExecutor> threadExecutorProvider;

  private Provider<PostExecutionThread> postExecutionThreadProvider;

  private Provider<UseCase> provideAllUseCaseProvider;

  private Provider<PrivateUserDataRepository> providePrivateRepositoryProvider;

  private Provider<UseCase> providePrivateUseCaseProvider;

  private MembersInjector<UserDataPresenter> userDataPresenterMembersInjector;

  private Provider<UserDataPresenter> userDataPresenterProvider;

  private MembersInjector<UserDataFragment> userDataFragmentMembersInjector;

  private MembersInjector<SearchFragment> searchFragmentMembersInjector;

  private DaggerGitHubUserComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideDBRepositoryProvider =
        new Factory<DBGitHubRepository>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public DBGitHubRepository get() {
            return Preconditions.checkNotNull(
                repositoryComponent.provideDBRepository(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.dBInteractorProvider = DBInteractor_Factory.create(provideDBRepositoryProvider);

    this.provideContextProvider =
        new Factory<Context>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public Context get() {
            return Preconditions.checkNotNull(
                repositoryComponent.provideContext(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.resultPresenterProvider =
        DoubleCheck.provider(
            ResultPresenter_Factory.create(dBInteractorProvider, provideContextProvider));

    this.provideRepositoryProvider =
        new Factory<GitHubDataRepository>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public GitHubDataRepository get() {
            return Preconditions.checkNotNull(
                repositoryComponent.provideRepository(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.threadExecutorProvider =
        new Factory<ThreadExecutor>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public ThreadExecutor get() {
            return Preconditions.checkNotNull(
                repositoryComponent.threadExecutor(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.postExecutionThreadProvider =
        new Factory<PostExecutionThread>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public PostExecutionThread get() {
            return Preconditions.checkNotNull(
                repositoryComponent.postExecutionThread(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideAllUseCaseProvider =
        DoubleCheck.provider(
            GitHubUserModule_ProvideAllUseCaseFactory.create(
                builder.gitHubUserModule,
                provideRepositoryProvider,
                threadExecutorProvider,
                postExecutionThreadProvider));

    this.providePrivateRepositoryProvider =
        new Factory<PrivateUserDataRepository>() {
          private final RepositoryComponent repositoryComponent = builder.repositoryComponent;

          @Override
          public PrivateUserDataRepository get() {
            return Preconditions.checkNotNull(
                repositoryComponent.providePrivateRepository(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providePrivateUseCaseProvider =
        DoubleCheck.provider(
            GitHubUserModule_ProvidePrivateUseCaseFactory.create(
                builder.gitHubUserModule,
                providePrivateRepositoryProvider,
                threadExecutorProvider,
                postExecutionThreadProvider));

    this.userDataPresenterMembersInjector =
        UserDataPresenter_MembersInjector.create(
            provideAllUseCaseProvider, providePrivateUseCaseProvider);

    this.userDataPresenterProvider =
        DoubleCheck.provider(
            UserDataPresenter_Factory.create(
                userDataPresenterMembersInjector, dBInteractorProvider, provideContextProvider));

    this.userDataFragmentMembersInjector =
        UserDataFragment_MembersInjector.create(resultPresenterProvider, userDataPresenterProvider);

    this.searchFragmentMembersInjector =
        SearchFragment_MembersInjector.create(userDataPresenterProvider);
  }

  @Override
  public void inject(UserDataFragment userListFragment) {
    userDataFragmentMembersInjector.injectMembers(userListFragment);
  }

  @Override
  public void inject(SearchFragment userDetailsFragment) {
    searchFragmentMembersInjector.injectMembers(userDetailsFragment);
  }

  public static final class Builder {
    private GitHubUserModule gitHubUserModule;

    private RepositoryComponent repositoryComponent;

    private Builder() {}

    public GitHubUserComponent build() {
      if (gitHubUserModule == null) {
        this.gitHubUserModule = new GitHubUserModule();
      }
      if (repositoryComponent == null) {
        throw new IllegalStateException(
            RepositoryComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerGitHubUserComponent(this);
    }

    public Builder gitHubUserModule(GitHubUserModule gitHubUserModule) {
      this.gitHubUserModule = Preconditions.checkNotNull(gitHubUserModule);
      return this;
    }

    public Builder repositoryComponent(RepositoryComponent repositoryComponent) {
      this.repositoryComponent = Preconditions.checkNotNull(repositoryComponent);
      return this;
    }
  }
}
