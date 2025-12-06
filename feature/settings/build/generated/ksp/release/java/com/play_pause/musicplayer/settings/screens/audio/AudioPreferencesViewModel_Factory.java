package com.play_pause.musicplayer.settings.screens.audio;

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
public final class AudioPreferencesViewModel_Factory implements Factory<AudioPreferencesViewModel> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public AudioPreferencesViewModel_Factory(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public AudioPreferencesViewModel get() {
    return newInstance(preferencesRepositoryProvider.get());
  }

  public static AudioPreferencesViewModel_Factory create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new AudioPreferencesViewModel_Factory(Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static AudioPreferencesViewModel_Factory create(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new AudioPreferencesViewModel_Factory(preferencesRepositoryProvider);
  }

  public static AudioPreferencesViewModel newInstance(PreferencesRepository preferencesRepository) {
    return new AudioPreferencesViewModel(preferencesRepository);
  }
}
