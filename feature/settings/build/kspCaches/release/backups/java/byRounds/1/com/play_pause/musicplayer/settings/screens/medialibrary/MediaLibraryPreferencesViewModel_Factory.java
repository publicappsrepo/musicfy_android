package com.play_pause.musicplayer.settings.screens.medialibrary;

import com.play_pause.musicplayer.core.data.repository.MediaRepository;
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
public final class MediaLibraryPreferencesViewModel_Factory implements Factory<MediaLibraryPreferencesViewModel> {
  private final Provider<MediaRepository> mediaRepositoryProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public MediaLibraryPreferencesViewModel_Factory(Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.mediaRepositoryProvider = mediaRepositoryProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public MediaLibraryPreferencesViewModel get() {
    return newInstance(mediaRepositoryProvider.get(), preferencesRepositoryProvider.get());
  }

  public static MediaLibraryPreferencesViewModel_Factory create(
      javax.inject.Provider<MediaRepository> mediaRepositoryProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new MediaLibraryPreferencesViewModel_Factory(Providers.asDaggerProvider(mediaRepositoryProvider), Providers.asDaggerProvider(preferencesRepositoryProvider));
  }

  public static MediaLibraryPreferencesViewModel_Factory create(
      Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new MediaLibraryPreferencesViewModel_Factory(mediaRepositoryProvider, preferencesRepositoryProvider);
  }

  public static MediaLibraryPreferencesViewModel newInstance(MediaRepository mediaRepository,
      PreferencesRepository preferencesRepository) {
    return new MediaLibraryPreferencesViewModel(mediaRepository, preferencesRepository);
  }
}
