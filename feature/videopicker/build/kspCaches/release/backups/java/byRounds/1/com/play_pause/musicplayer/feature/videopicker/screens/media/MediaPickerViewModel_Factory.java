package com.play_pause.musicplayer.feature.videopicker.screens.media;

import com.play_pause.musicplayer.core.data.repository.PreferencesRepository;
import com.play_pause.musicplayer.core.domain.GetSortedMediaUseCase;
import com.play_pause.musicplayer.core.media.services.MediaService;
import com.play_pause.musicplayer.core.media.sync.MediaInfoSynchronizer;
import com.play_pause.musicplayer.core.media.sync.MediaSynchronizer;
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
public final class MediaPickerViewModel_Factory implements Factory<MediaPickerViewModel> {
  private final Provider<GetSortedMediaUseCase> getSortedMediaUseCaseProvider;

  private final Provider<MediaService> mediaServiceProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<MediaInfoSynchronizer> mediaInfoSynchronizerProvider;

  private final Provider<MediaSynchronizer> mediaSynchronizerProvider;

  public MediaPickerViewModel_Factory(Provider<GetSortedMediaUseCase> getSortedMediaUseCaseProvider,
      Provider<MediaService> mediaServiceProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<MediaInfoSynchronizer> mediaInfoSynchronizerProvider,
      Provider<MediaSynchronizer> mediaSynchronizerProvider) {
    this.getSortedMediaUseCaseProvider = getSortedMediaUseCaseProvider;
    this.mediaServiceProvider = mediaServiceProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.mediaInfoSynchronizerProvider = mediaInfoSynchronizerProvider;
    this.mediaSynchronizerProvider = mediaSynchronizerProvider;
  }

  @Override
  public MediaPickerViewModel get() {
    return newInstance(getSortedMediaUseCaseProvider.get(), mediaServiceProvider.get(), preferencesRepositoryProvider.get(), mediaInfoSynchronizerProvider.get(), mediaSynchronizerProvider.get());
  }

  public static MediaPickerViewModel_Factory create(
      javax.inject.Provider<GetSortedMediaUseCase> getSortedMediaUseCaseProvider,
      javax.inject.Provider<MediaService> mediaServiceProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<MediaInfoSynchronizer> mediaInfoSynchronizerProvider,
      javax.inject.Provider<MediaSynchronizer> mediaSynchronizerProvider) {
    return new MediaPickerViewModel_Factory(Providers.asDaggerProvider(getSortedMediaUseCaseProvider), Providers.asDaggerProvider(mediaServiceProvider), Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(mediaInfoSynchronizerProvider), Providers.asDaggerProvider(mediaSynchronizerProvider));
  }

  public static MediaPickerViewModel_Factory create(
      Provider<GetSortedMediaUseCase> getSortedMediaUseCaseProvider,
      Provider<MediaService> mediaServiceProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<MediaInfoSynchronizer> mediaInfoSynchronizerProvider,
      Provider<MediaSynchronizer> mediaSynchronizerProvider) {
    return new MediaPickerViewModel_Factory(getSortedMediaUseCaseProvider, mediaServiceProvider, preferencesRepositoryProvider, mediaInfoSynchronizerProvider, mediaSynchronizerProvider);
  }

  public static MediaPickerViewModel newInstance(GetSortedMediaUseCase getSortedMediaUseCase,
      MediaService mediaService, PreferencesRepository preferencesRepository,
      MediaInfoSynchronizer mediaInfoSynchronizer, MediaSynchronizer mediaSynchronizer) {
    return new MediaPickerViewModel(getSortedMediaUseCase, mediaService, preferencesRepository, mediaInfoSynchronizer, mediaSynchronizer);
  }
}
