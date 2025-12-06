package com.play_pause.musicplayer.core.data.repository;

import com.play_pause.musicplayer.core.datastore.datasource.AppPreferencesDataSource;
import com.play_pause.musicplayer.core.datastore.datasource.PlayerPreferencesDataSource;
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
public final class LocalPreferencesRepository_Factory implements Factory<LocalPreferencesRepository> {
  private final Provider<AppPreferencesDataSource> appPreferencesDataSourceProvider;

  private final Provider<PlayerPreferencesDataSource> playerPreferencesDataSourceProvider;

  public LocalPreferencesRepository_Factory(
      Provider<AppPreferencesDataSource> appPreferencesDataSourceProvider,
      Provider<PlayerPreferencesDataSource> playerPreferencesDataSourceProvider) {
    this.appPreferencesDataSourceProvider = appPreferencesDataSourceProvider;
    this.playerPreferencesDataSourceProvider = playerPreferencesDataSourceProvider;
  }

  @Override
  public LocalPreferencesRepository get() {
    return newInstance(appPreferencesDataSourceProvider.get(), playerPreferencesDataSourceProvider.get());
  }

  public static LocalPreferencesRepository_Factory create(
      javax.inject.Provider<AppPreferencesDataSource> appPreferencesDataSourceProvider,
      javax.inject.Provider<PlayerPreferencesDataSource> playerPreferencesDataSourceProvider) {
    return new LocalPreferencesRepository_Factory(Providers.asDaggerProvider(appPreferencesDataSourceProvider), Providers.asDaggerProvider(playerPreferencesDataSourceProvider));
  }

  public static LocalPreferencesRepository_Factory create(
      Provider<AppPreferencesDataSource> appPreferencesDataSourceProvider,
      Provider<PlayerPreferencesDataSource> playerPreferencesDataSourceProvider) {
    return new LocalPreferencesRepository_Factory(appPreferencesDataSourceProvider, playerPreferencesDataSourceProvider);
  }

  public static LocalPreferencesRepository newInstance(
      AppPreferencesDataSource appPreferencesDataSource,
      PlayerPreferencesDataSource playerPreferencesDataSource) {
    return new LocalPreferencesRepository(appPreferencesDataSource, playerPreferencesDataSource);
  }
}
