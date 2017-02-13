package com.example.app.testapp.presentation.internal.di.modules;

import android.support.v7.app.AppCompatActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ActivityFactory implements Factory<AppCompatActivity> {
  private final ActivityModule module;

  public ActivityModule_ActivityFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AppCompatActivity get() {
    return Preconditions.checkNotNull(
        module.activity(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AppCompatActivity> create(ActivityModule module) {
    return new ActivityModule_ActivityFactory(module);
  }

  /** Proxies {@link ActivityModule#activity()}. */
  public static AppCompatActivity proxyActivity(ActivityModule instance) {
    return instance.activity();
  }
}
