package com.play_pause.musicplayer.settings.screens.appearance;

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
public final class AppearancePreferencesViewModel_Factory implements Factory<AppearancePreferencesViewModel> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public AppearancePreferencesViewModel_Factory(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public AppearancePreferencesViewModel get() {
    return newInstance(preferencesRepositoryProvider.get());
  }

  public static AppearancePreferencesViewModel_Factory create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new AppearancePreferencesViewModel_Factory(Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static AppearancePreferencesViewModel_Factory create(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new AppearancePreferencesViewModel_Factory(preferencesRepositoryProvider);
  }

  public static AppearancePreferencesViewModel newInstance(
      PreferencesRepository preferencesRepository) {
    return new AppearancePreferencesViewModel(preferencesRepository);
  }
}
