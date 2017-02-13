package com.example.app.testapp.presentation.internal.di.components;

import android.content.Context;
import com.example.app.testapp.data.entity.mapper.PrivateUserDataMapper;
import com.example.app.testapp.data.entity.mapper.PrivateUserDataMapper_Factory;
import com.example.app.testapp.data.entity.mapper.PrivateUserReposDataMapper;
import com.example.app.testapp.data.entity.mapper.PrivateUserReposDataMapper_Factory;
import com.example.app.testapp.data.entity.mapper.UserDataMapper;
import com.example.app.testapp.data.entity.mapper.UserDataMapper_Factory;
import com.example.app.testapp.data.entity.mapper.UserRepositoryDataMapper;
import com.example.app.testapp.data.entity.mapper.UserRepositoryDataMapper_Factory;
import com.example.app.testapp.data.repository.GitHubDataRepository;
import com.example.app.testapp.data.repository.GitHubDataRepository_Factory;
import com.example.app.testapp.data.repository.PrivateUserDataRepository;
import com.example.app.testapp.data.repository.PrivateUserDataRepository_Factory;
import com.example.app.testapp.data.repository.PrivateUserDataRepository_MembersInjector;
import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl;
import com.example.app.testapp.data.repository.RealmGitHubRepositoryImpl_Factory;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory;
import com.example.app.testapp.data.repository.datasource.GitHubDataStoreFactory_Factory;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.repository.DBGitHubRepository;
import com.example.app.testapp.presentation.activity.BaseActivity;
import com.example.app.testapp.presentation.internal.di.modules.RepositoryModule;
import com.example.app.testapp.presentation.internal.di.modules.RepositoryModule_ProvideDBGitHubRepositoryFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRepositoryComponent implements RepositoryComponent {
  private Provider<Realm> provideRealmProvider;

  private Provider<RealmGitHubRepositoryImpl> realmGitHubRepositoryImplProvider;

  private Provider<DBGitHubRepository> provideDBGitHubRepositoryProvider;

  private Provider<Context> contextProvider;

  private MembersInjector<PrivateUserDataRepository> privateUserDataRepositoryMembersInjector;

  private Provider<GitHubDataStoreFactory> gitHubDataStoreFactoryProvider;

  private Provider<PrivateUserDataMapper> privateUserDataMapperProvider;

  private Provider<PrivateUserReposDataMapper> privateUserReposDataMapperProvider;

  private Provider<PrivateUserDataRepository> privateUserDataRepositoryProvider;

  private Provider<UserDataMapper> userDataMapperProvider;

  private Provider<UserRepositoryDataMapper> userRepositoryDataMapperProvider;

  private Provider<GitHubDataRepository> gitHubDataRepositoryProvider;

  private Provider<ThreadExecutor> threadExecutorProvider;

  private Provider<PostExecutionThread> postExecutionThreadProvider;

  private DaggerRepositoryComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideRealmProvider =
        new Factory<Realm>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Realm get() {
            return Preconditions.checkNotNull(
                applicationComponent.provideRealm(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.realmGitHubRepositoryImplProvider =
        DoubleCheck.provider(RealmGitHubRepositoryImpl_Factory.create(provideRealmProvider));

    this.provideDBGitHubRepositoryProvider =
        DoubleCheck.provider(
            RepositoryModule_ProvideDBGitHubRepositoryFactory.create(
                builder.repositoryModule, realmGitHubRepositoryImplProvider));

    this.contextProvider =
        new Factory<Context>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Context get() {
            return Preconditions.checkNotNull(
                applicationComponent.context(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.privateUserDataRepositoryMembersInjector =
        PrivateUserDataRepository_MembersInjector.create(contextProvider);

    this.gitHubDataStoreFactoryProvider =
        DoubleCheck.provider(GitHubDataStoreFactory_Factory.create());

    this.privateUserDataMapperProvider =
        DoubleCheck.provider(PrivateUserDataMapper_Factory.create());

    this.privateUserReposDataMapperProvider =
        DoubleCheck.provider(PrivateUserReposDataMapper_Factory.create());

    this.privateUserDataRepositoryProvider =
        DoubleCheck.provider(
            PrivateUserDataRepository_Factory.create(
                privateUserDataRepositoryMembersInjector,
                gitHubDataStoreFactoryProvider,
                privateUserDataMapperProvider,
                privateUserReposDataMapperProvider));

    this.userDataMapperProvider = DoubleCheck.provider(UserDataMapper_Factory.create());

    this.userRepositoryDataMapperProvider =
        DoubleCheck.provider(UserRepositoryDataMapper_Factory.create());

    this.gitHubDataRepositoryProvider =
        DoubleCheck.provider(
            GitHubDataRepository_Factory.create(
                gitHubDataStoreFactoryProvider,
                userDataMapperProvider,
                userRepositoryDataMapperProvider));

    this.threadExecutorProvider =
        new Factory<ThreadExecutor>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public ThreadExecutor get() {
            return Preconditions.checkNotNull(
                applicationComponent.threadExecutor(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.postExecutionThreadProvider =
        new Factory<PostExecutionThread>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public PostExecutionThread get() {
            return Preconditions.checkNotNull(
                applicationComponent.postExecutionThread(),
                "Cannot return null from a non-@Nullable component method");
          }
        };
  }

  @Override
  public void inject(BaseActivity baseActivity) {
    MembersInjectors.<BaseActivity>noOp().injectMembers(baseActivity);
  }

  @Override
  public DBGitHubRepository provideDBRepository() {
    return provideDBGitHubRepositoryProvider.get();
  }

  @Override
  public PrivateUserDataRepository providePrivateRepository() {
    return privateUserDataRepositoryProvider.get();
  }

  @Override
  public GitHubDataRepository provideRepository() {
    return gitHubDataRepositoryProvider.get();
  }

  @Override
  public ThreadExecutor threadExecutor() {
    return threadExecutorProvider.get();
  }

  @Override
  public PostExecutionThread postExecutionThread() {
    return postExecutionThreadProvider.get();
  }

  @Override
  public Context provideContext() {
    return contextProvider.get();
  }

  public static final class Builder {
    private RepositoryModule repositoryModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public RepositoryComponent build() {
      if (repositoryModule == null) {
        this.repositoryModule = new RepositoryModule();
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerRepositoryComponent(this);
    }

    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
