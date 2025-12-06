package com.play_pause.musicplayer.core.datastore.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.play_pause.musicplayer.core.model.ApplicationPreferences;
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
public final class DataStoreModule_ProvideAppPreferencesDataStoreFactory implements Factory<DataStore<ApplicationPreferences>> {
  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<CoroutineScope> scopeProvider;

  public DataStoreModule_ProvideAppPreferencesDataStoreFactory(Provider<Context> contextProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<CoroutineScope> scopeProvider) {
    this.contextProvider = contextProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.scopeProvider = scopeProvider;
  }

  @Override
  public DataStore<ApplicationPreferences> get() {
    return provideAppPreferencesDataStore(contextProvider.get(), ioDispatcherProvider.get(), scopeProvider.get());
  }

  public static DataStoreModule_ProvideAppPreferencesDataStoreFactory create(
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<CoroutineDispatcher> ioDispatcherProvider,
      javax.inject.Provider<CoroutineScope> scopeProvider) {
    return new DataStoreModule_ProvideAppPreferencesDataStoreFactory(Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(ioDispatcherProvider), Providers.asDaggerProvider(scopeProvider));
  }

  public static DataStoreModule_ProvideAppPreferencesDataStoreFactory create(
      Provider<Context> contextProvider, Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<CoroutineScope> scopeProvider) {
    return new DataStoreModule_ProvideAppPreferencesDataStoreFactory(contextProvider, ioDispatcherProvider, scopeProvider);
  }

  public static DataStore<ApplicationPreferences> provideAppPreferencesDataStore(Context context,
      CoroutineDispatcher ioDispatcher, CoroutineScope scope) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideAppPreferencesDataStore(context, ioDispatcher, scope));
  }
}
