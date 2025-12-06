package com.play_pause.musicplayer.core.datastore.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.play_pause.musicplayer.core.model.PlayerPreferences;
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
    "dagger.hilt.android.qualifiers.ApplicationContext",
    "com.play_pause.musicplayer.core.common.Dispatcher",
    "com.play_pause.musicplayer.core.common.di.ApplicationScope"
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
public final class DataStoreModule_ProvidePlayerPreferencesDataStoreFactory implements Factory<DataStore<PlayerPreferences>> {
  private final Provider<Context> applicationContextProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<CoroutineScope> scopeProvider;

  public DataStoreModule_ProvidePlayerPreferencesDataStoreFactory(
      Provider<Context> applicationContextProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<CoroutineScope> scopeProvider) {
    this.applicationContextProvider = applicationContextProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.scopeProvider = scopeProvider;
  }

  @Override
  public DataStore<PlayerPreferences> get() {
    return providePlayerPreferencesDataStore(applicationContextProvider.get(), ioDispatcherProvider.get(), scopeProvider.get());
  }

  public static DataStoreModule_ProvidePlayerPreferencesDataStoreFactory create(
      javax.inject.Provider<Context> applicationContextProvider,
      javax.inject.Provider<CoroutineDispatcher> ioDispatcherProvider,
      javax.inject.Provider<CoroutineScope> scopeProvider) {
    return new DataStoreModule_ProvidePlayerPreferencesDataStoreFactory(Providers.asDaggerProvider(applicationContextProvider), Providers.asDaggerProvider(ioDispatcherProvider), Providers.asDaggerProvider(scopeProvider));
  }

  public static DataStoreModule_ProvidePlayerPreferencesDataStoreFactory create(
      Provider<Context> applicationContextProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<CoroutineScope> scopeProvider) {
    return new DataStoreModule_ProvidePlayerPreferencesDataStoreFactory(applicationContextProvider, ioDispatcherProvider, scopeProvider);
  }

  public static DataStore<PlayerPreferences> providePlayerPreferencesDataStore(
      Context applicationContext, CoroutineDispatcher ioDispatcher, CoroutineScope scope) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.providePlayerPreferencesDataStore(applicationContext, ioDispatcher, scope));
  }
}
