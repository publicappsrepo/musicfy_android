package com.play_pause.musicplayer.settings.screens.subtitle;

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
public final class SubtitlePreferencesViewModel_Factory implements Factory<SubtitlePreferencesViewModel> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public SubtitlePreferencesViewModel_Factory(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public SubtitlePreferencesViewModel get() {
    return newInstance(preferencesRepositoryProvider.get());
  }

  public static SubtitlePreferencesViewModel_Factory create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new SubtitlePreferencesViewModel_Factory(Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static SubtitlePreferencesViewModel_Factory create(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new SubtitlePreferencesViewModel_Factory(preferencesRepositoryProvider);
  }

  public static SubtitlePreferencesViewModel newInstance(
      PreferencesRepository preferencesRepository) {
    return new SubtitlePreferencesViewModel(preferencesRepository);
  }
}
