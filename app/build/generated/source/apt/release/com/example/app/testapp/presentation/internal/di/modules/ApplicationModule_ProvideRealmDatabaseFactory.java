package com.example.app.testapp.presentation.internal.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideRealmDatabaseFactory implements Factory<Realm> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideRealmDatabaseFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Realm get() {
    return Preconditions.checkNotNull(
        module.provideRealmDatabase(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Realm> create(ApplicationModule module) {
    return new ApplicationModule_ProvideRealmDatabaseFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideRealmDatabase()}. */
  public static Realm proxyProvideRealmDatabase(ApplicationModule instance) {
    return instance.provideRealmDatabase();
  }
}
