package com.example.app.testapp.presentation.internal.di.components;

import android.content.Context;
import com.example.app.testapp.data.executor.JobExecutor;
import com.example.app.testapp.data.executor.JobExecutor_Factory;
import com.example.app.testapp.domain.executor.PostExecutionThread;
import com.example.app.testapp.domain.executor.ThreadExecutor;
import com.example.app.testapp.domain.executor.UpdateUserInterfaceThread;
import com.example.app.testapp.domain.executor.UpdateUserInterfaceThread_Factory;
import com.example.app.testapp.presentation.activity.BaseActivity;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule_ProvideApplicationContextFactory;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule_ProvidePostExecutionThreadFactory;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule_ProvideRealmDatabaseFactory;
import com.example.app.testapp.presentation.internal.di.modules.ApplicationModule_ProvideThreadExecutorFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<JobExecutor> jobExecutorProvider;

  private Provider<ThreadExecutor> provideThreadExecutorProvider;

  private Provider<UpdateUserInterfaceThread> updateUserInterfaceThreadProvider;

  private Provider<PostExecutionThread> providePostExecutionThreadProvider;

  private Provider<Realm> provideRealmDatabaseProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationContextFactory.create(builder.applicationModule));

    this.jobExecutorProvider = DoubleCheck.provider(JobExecutor_Factory.create());

    this.provideThreadExecutorProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideThreadExecutorFactory.create(
                builder.applicationModule, jobExecutorProvider));

    this.updateUserInterfaceThreadProvider =
        DoubleCheck.provider(UpdateUserInterfaceThread_Factory.create());

    this.providePostExecutionThreadProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidePostExecutionThreadFactory.create(
                builder.applicationModule, updateUserInterfaceThreadProvider));

    this.provideRealmDatabaseProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideRealmDatabaseFactory.create(builder.applicationModule));
  }

  @Override
  public void inject(BaseActivity baseActivity) {
    MembersInjectors.<BaseActivity>noOp().injectMembers(baseActivity);
  }

  @Override
  public Context context() {
    return provideApplicationContextProvider.get();
  }

  @Override
  public ThreadExecutor threadExecutor() {
    return provideThreadExecutorProvider.get();
  }

  @Override
  public PostExecutionThread postExecutionThread() {
    return providePostExecutionThreadProvider.get();
  }

  @Override
  public Realm provideRealm() {
    return provideRealmDatabaseProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
