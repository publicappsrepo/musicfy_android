package com.play_pause.musicplayer.core.datastore.datasource;

import androidx.datastore.core.DataStore;
import com.play_pause.musicplayer.core.model.ApplicationPreferences;
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
public final class AppPreferencesDataSource_Factory implements Factory<AppPreferencesDataSource> {
  private final Provider<DataStore<ApplicationPreferences>> appPreferencesProvider;

  public AppPreferencesDataSource_Factory(
      Provider<DataStore<ApplicationPreferences>> appPreferencesProvider) {
    this.appPreferencesProvider = appPreferencesProvider;
  }

  @Override
  public AppPreferencesDataSource get() {
    return newInstance(appPreferencesProvider.get());
  }

  public static AppPreferencesDataSource_Factory create(
      javax.inject.Provider<DataStore<ApplicationPreferences>> appPreferencesProvider) {
    return new AppPreferencesDataSource_Factory(Providers.asDaggerProvider(appPreferencesProvider));
  }

  public static AppPreferencesDataSource_Factory create(
      Provider<DataStore<ApplicationPreferences>> appPreferencesProvider) {
    return new AppPreferencesDataSource_Factory(appPreferencesProvider);
  }

  public static AppPreferencesDataSource newInstance(
      DataStore<ApplicationPreferences> appPreferences) {
    return new AppPreferencesDataSource(appPreferences);
  }
}
