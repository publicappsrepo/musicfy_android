package com.play_pause.musicplayer.settings.screens.decoder;

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
public final class DecoderPreferencesViewModel_Factory implements Factory<DecoderPreferencesViewModel> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public DecoderPreferencesViewModel_Factory(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public DecoderPreferencesViewModel get() {
    return newInstance(preferencesRepositoryProvider.get());
  }

  public static DecoderPreferencesViewModel_Factory create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new DecoderPreferencesViewModel_Factory(Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static DecoderPreferencesViewModel_Factory create(
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new DecoderPreferencesViewModel_Factory(preferencesRepositoryProvider);
  }

  public static DecoderPreferencesViewModel newInstance(
      PreferencesRepository preferencesRepository) {
    return new DecoderPreferencesViewModel(preferencesRepository);
  }
}
