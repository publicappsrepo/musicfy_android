package com.play_pause.musicplayer.settings.screens.player;

import com.play_pause.musicplayer.core.data.repository.PreferencesRepository;
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
public final class PlayerPreferencesViewModel_Factory implements Factory<PlayerPreferencesViewModel> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public PlayerPreferencesViewModel_Factory(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public PlayerPreferencesViewModel get() {
    return newInstance(preferencesRepositoryProvider.get());
  }

  public static PlayerPreferencesViewModel_Factory create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new PlayerPreferencesViewModel_Factory(Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static PlayerPreferencesViewModel_Factory create(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new PlayerPreferencesViewModel_Factory(preferencesRepositoryProvider);
  }

  public static PlayerPreferencesViewModel newInstance(
      PreferencesRepository preferencesRepository) {
    return new PlayerPreferencesViewModel(preferencesRepository);
  }
}
