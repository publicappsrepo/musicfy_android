package com.play_pause.musicplayer.core.domain;

import com.play_pause.musicplayer.core.data.repository.MediaRepository;
import com.play_pause.musicplayer.core.data.repository.PreferencesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.play_pause.musicplayer.core.common.Dispatcher")
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
public final class GetSortedVideosUseCase_Factory implements Factory<GetSortedVideosUseCase> {
  private final Provider<MediaRepository> mediaRepositoryProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<CoroutineDispatcher> defaultDispatcherProvider;

  public GetSortedVideosUseCase_Factory(Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    this.mediaRepositoryProvider = mediaRepositoryProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.defaultDispatcherProvider = defaultDispatcherProvider;
  }

  @Override
  public GetSortedVideosUseCase get() {
    return newInstance(mediaRepositoryProvider.get(), preferencesRepositoryProvider.get(), defaultDispatcherProvider.get());
  }

  public static GetSortedVideosUseCase_Factory create(
      javax.inject.Provider<MediaRepository> mediaRepositoryProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedVideosUseCase_Factory(Providers.asDaggerProvider(mediaRepositoryProvider), Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(defaultDispatcherProvider));
  }

  public static GetSortedVideosUseCase_Factory create(
      Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedVideosUseCase_Factory(mediaRepositoryProvider, preferencesRepositoryProvider, defaultDispatcherProvider);
  }

  public static GetSortedVideosUseCase newInstance(MediaRepository mediaRepository,
      PreferencesRepository preferencesRepository, CoroutineDispatcher defaultDispatcher) {
    return new GetSortedVideosUseCase(mediaRepository, preferencesRepository, defaultDispatcher);
  }
}
