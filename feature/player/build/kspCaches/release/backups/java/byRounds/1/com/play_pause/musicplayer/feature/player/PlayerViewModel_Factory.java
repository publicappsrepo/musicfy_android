package com.play_pause.musicplayer.feature.player;

import com.play_pause.musicplayer.core.data.repository.MediaRepository;
import com.play_pause.musicplayer.core.data.repository.PreferencesRepository;
import com.play_pause.musicplayer.core.domain.GetSortedPlaylistUseCase;
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
public final class PlayerViewModel_Factory implements Factory<PlayerViewModel> {
  private final Provider<MediaRepository> mediaRepositoryProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<GetSortedPlaylistUseCase> getSortedPlaylistUseCaseProvider;

  public PlayerViewModel_Factory(Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<GetSortedPlaylistUseCase> getSortedPlaylistUseCaseProvider) {
    this.mediaRepositoryProvider = mediaRepositoryProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.getSortedPlaylistUseCaseProvider = getSortedPlaylistUseCaseProvider;
  }

  @Override
  public PlayerViewModel get() {
    return newInstance(mediaRepositoryProvider.get(), preferencesRepositoryProvider.get(), getSortedPlaylistUseCaseProvider.get());
  }

  public static PlayerViewModel_Factory create(
      javax.inject.Provider<MediaRepository> mediaRepositoryProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<GetSortedPlaylistUseCase> getSortedPlaylistUseCaseProvider) {
    return new PlayerViewModel_Factory(Providers.asDaggerProvider(mediaRepositoryProvider), Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(getSortedPlaylistUseCaseProvider));
  }

  public static PlayerViewModel_Factory create(Provider<MediaRepository> mediaRepositoryProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<GetSortedPlaylistUseCase> getSortedPlaylistUseCaseProvider) {
    return new PlayerViewModel_Factory(mediaRepositoryProvider, preferencesRepositoryProvider, getSortedPlaylistUseCaseProvider);
  }

  public static PlayerViewModel newInstance(MediaRepository mediaRepository,
      PreferencesRepository preferencesRepository,
      GetSortedPlaylistUseCase getSortedPlaylistUseCase) {
    return new PlayerViewModel(mediaRepository, preferencesRepository, getSortedPlaylistUseCase);
  }
}
