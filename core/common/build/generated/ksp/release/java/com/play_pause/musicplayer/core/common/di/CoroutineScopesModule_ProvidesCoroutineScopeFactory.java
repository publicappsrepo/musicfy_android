package com.play_pause.musicplayer.core.common.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "com.play_pause.musicplayer.core.common.di.ApplicationScope",
    "com.play_pause.musicplayer.core.common.Dispatcher"
})
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class CoroutineScopesModule_ProvidesCoroutineScopeFactory implements Factory<CoroutineScope> {
  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public CoroutineScopesModule_ProvidesCoroutineScopeFactory(
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public CoroutineScope get() {
    return providesCoroutineScope(dispatcherProvider.get());
  }

  public static CoroutineScopesModule_ProvidesCoroutineScopeFactory create(
      javax.inject.Provider<CoroutineDispatcher> dispatcherProvider) {
    return new CoroutineScopesModule_ProvidesCoroutineScopeFactory(Providers.asDaggerProvider(dispatcherProvider));
  }

  public static CoroutineScopesModule_ProvidesCoroutineScopeFactory create(
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new CoroutineScopesModule_ProvidesCoroutineScopeFactory(dispatcherProvider);
  }

  public static CoroutineScope providesCoroutineScope(CoroutineDispatcher dispatcher) {
    return Preconditions.checkNotNullFromProvides(CoroutineScopesModule.INSTANCE.providesCoroutineScope(dispatcher));
  }
}
