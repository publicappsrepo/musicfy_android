package com.play_pause.musicplayer.feature.player.service;

import com.play_pause.musicplayer.core.data.repository.MediaRepository;
import com.play_pause.musicplayer.core.data.repository.PreferencesRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class PlayerService_MembersInjector implements MembersInjector<PlayerService> {
  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<MediaRepository> mediaRepositoryProvider;

  public PlayerService_MembersInjector(
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<MediaRepository> mediaRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.mediaRepositoryProvider = mediaRepositoryProvider;
  }

  public static MembersInjector<PlayerService> create(
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<MediaRepository> mediaRepositoryProvider) {
    return new PlayerService_MembersInjector(preferencesRepositoryProvider, mediaRepositoryProvider);
  }

  public static MembersInjector<PlayerService> create(
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<MediaRepository> mediaRepositoryProvider) {
    return new PlayerService_MembersInjector(Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(mediaRepositoryProvider));
  }

  @Override
  public void injectMembers(PlayerService instance) {
    injectPreferencesRepository(instance, preferencesRepositoryProvider.get());
    injectMediaRepository(instance, mediaRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.play_pause.musicplayer.feature.player.service.PlayerService.preferencesRepository")
  public static void injectPreferencesRepository(PlayerService instance,
      PreferencesRepository preferencesRepository) {
    instance.preferencesRepository = preferencesRepository;
  }

  @InjectedFieldSignature("com.play_pause.musicplayer.feature.player.service.PlayerService.mediaRepository")
  public static void injectMediaRepository(PlayerService instance,
      MediaRepository mediaRepository) {
    instance.mediaRepository = mediaRepository;
  }
}
