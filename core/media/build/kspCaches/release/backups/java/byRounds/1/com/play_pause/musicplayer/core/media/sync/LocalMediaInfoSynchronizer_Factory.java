package com.play_pause.musicplayer.core.media.sync;

import android.content.Context;
import com.play_pause.musicplayer.core.database.dao.MediumDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata
@QualifierMetadata({
    "com.play_pause.musicplayer.core.common.di.ApplicationScope",
    "dagger.hilt.android.qualifiers.ApplicationContext",
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
public final class LocalMediaInfoSynchronizer_Factory implements Factory<LocalMediaInfoSynchronizer> {
  private final Provider<MediumDao> mediumDaoProvider;

  private final Provider<CoroutineScope> applicationScopeProvider;

  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public LocalMediaInfoSynchronizer_Factory(Provider<MediumDao> mediumDaoProvider,
      Provider<CoroutineScope> applicationScopeProvider, Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.mediumDaoProvider = mediumDaoProvider;
    this.applicationScopeProvider = applicationScopeProvider;
    this.contextProvider = contextProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public LocalMediaInfoSynchronizer get() {
    return newInstance(mediumDaoProvider.get(), applicationScopeProvider.get(), contextProvider.get(), dispatcherProvider.get());
  }

  public static LocalMediaInfoSynchronizer_Factory create(
      javax.inject.Provider<MediumDao> mediumDaoProvider,
      javax.inject.Provider<CoroutineScope> applicationScopeProvider,
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<CoroutineDispatcher> dispatcherProvider) {
    return new LocalMediaInfoSynchronizer_Factory(Providers.asDaggerProvider(mediumDaoProvider), Providers.asDaggerProvider(applicationScopeProvider), Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(dispatcherProvider));
  }

  public static LocalMediaInfoSynchronizer_Factory create(Provider<MediumDao> mediumDaoProvider,
      Provider<CoroutineScope> applicationScopeProvider, Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new LocalMediaInfoSynchronizer_Factory(mediumDaoProvider, applicationScopeProvider, contextProvider, dispatcherProvider);
  }

  public static LocalMediaInfoSynchronizer newInstance(MediumDao mediumDao,
      CoroutineScope applicationScope, Context context, CoroutineDispatcher dispatcher) {
    return new LocalMediaInfoSynchronizer(mediumDao, applicationScope, context, dispatcher);
  }
}
