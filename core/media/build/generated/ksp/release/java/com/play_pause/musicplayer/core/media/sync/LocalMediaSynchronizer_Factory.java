package com.play_pause.musicplayer.core.media.sync;

import android.content.Context;
import com.play_pause.musicplayer.core.database.dao.DirectoryDao;
import com.play_pause.musicplayer.core.database.dao.MediumDao;
import com.play_pause.musicplayer.core.database.dao.MediumStateDao;
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
public final class LocalMediaSynchronizer_Factory implements Factory<LocalMediaSynchronizer> {
  private final Provider<MediumDao> mediumDaoProvider;

  private final Provider<MediumStateDao> mediumStateDaoProvider;

  private final Provider<DirectoryDao> directoryDaoProvider;

  private final Provider<CoroutineScope> applicationScopeProvider;

  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public LocalMediaSynchronizer_Factory(Provider<MediumDao> mediumDaoProvider,
      Provider<MediumStateDao> mediumStateDaoProvider, Provider<DirectoryDao> directoryDaoProvider,
      Provider<CoroutineScope> applicationScopeProvider, Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.mediumDaoProvider = mediumDaoProvider;
    this.mediumStateDaoProvider = mediumStateDaoProvider;
    this.directoryDaoProvider = directoryDaoProvider;
    this.applicationScopeProvider = applicationScopeProvider;
    this.contextProvider = contextProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public LocalMediaSynchronizer get() {
    return newInstance(mediumDaoProvider.get(), mediumStateDaoProvider.get(), directoryDaoProvider.get(), applicationScopeProvider.get(), contextProvider.get(), dispatcherProvider.get());
  }

  public static LocalMediaSynchronizer_Factory create(
      javax.inject.Provider<MediumDao> mediumDaoProvider,
      javax.inject.Provider<MediumStateDao> mediumStateDaoProvider,
      javax.inject.Provider<DirectoryDao> directoryDaoProvider,
      javax.inject.Provider<CoroutineScope> applicationScopeProvider,
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<CoroutineDispatcher> dispatcherProvider) {
    return new LocalMediaSynchronizer_Factory(Providers.asDaggerProvider(mediumDaoProvider), Providers.asDaggerProvider(mediumStateDaoProvider), Providers.asDaggerProvider(directoryDaoProvider), Providers.asDaggerProvider(applicationScopeProvider), Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(dispatcherProvider));
  }

  public static LocalMediaSynchronizer_Factory create(Provider<MediumDao> mediumDaoProvider,
      Provider<MediumStateDao> mediumStateDaoProvider, Provider<DirectoryDao> directoryDaoProvider,
      Provider<CoroutineScope> applicationScopeProvider, Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new LocalMediaSynchronizer_Factory(mediumDaoProvider, mediumStateDaoProvider, directoryDaoProvider, applicationScopeProvider, contextProvider, dispatcherProvider);
  }

  public static LocalMediaSynchronizer newInstance(MediumDao mediumDao,
      MediumStateDao mediumStateDao, DirectoryDao directoryDao, CoroutineScope applicationScope,
      Context context, CoroutineDispatcher dispatcher) {
    return new LocalMediaSynchronizer(mediumDao, mediumStateDao, directoryDao, applicationScope, context, dispatcher);
  }
}
