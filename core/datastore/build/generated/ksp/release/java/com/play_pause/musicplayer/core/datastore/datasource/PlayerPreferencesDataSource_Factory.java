package com.play_pause.musicplayer.core.datastore.datasource;

import androidx.datastore.core.DataStore;
import com.play_pause.musicplayer.core.model.PlayerPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class PlayerPreferencesDataSource_Factory implements Factory<PlayerPreferencesDataSource> {
  private final Provider<DataStore<PlayerPreferences>> preferencesDataStoreProvider;

  public PlayerPreferencesDataSource_Factory(
      Provider<DataStore<PlayerPreferences>> preferencesDataStoreProvider) {
    this.preferencesDataStoreProvider = preferencesDataStoreProvider;
  }

  @Override
  public PlayerPreferencesDataSource get() {
    return newInstance(preferencesDataStoreProvider.get());
  }

  public static PlayerPreferencesDataSource_Factory create(
      javax.inject.Provider<DataStore<PlayerPreferences>> preferencesDataStoreProvider) {
    return new PlayerPreferencesDataSource_Factory(Providers.asDaggerProvider(preferencesDataStoreProvider));
  }

  public static PlayerPreferencesDataSource_Factory create(
      Provider<DataStore<PlayerPreferences>> preferencesDataStoreProvider) {
    return new PlayerPreferencesDataSource_Factory(preferencesDataStoreProvider);
  }

  public static PlayerPreferencesDataSource newInstance(
      DataStore<PlayerPreferences> preferencesDataStore) {
    return new PlayerPreferencesDataSource(preferencesDataStore);
  }
}
