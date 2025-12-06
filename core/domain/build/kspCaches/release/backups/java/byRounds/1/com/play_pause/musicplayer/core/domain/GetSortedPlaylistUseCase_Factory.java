package com.play_pause.musicplayer.core.domain;

import android.content.Context;
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
@QualifierMetadata({
    "dagger.hilt.android.qualifiers.ApplicationContext",
    "com.play_pause.musicplayer.core.common.Dispatcher"
})
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
public final class GetSortedPlaylistUseCase_Factory implements Factory<GetSortedPlaylistUseCase> {
  private final Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<Context> contextProvider;

  private final Provider<CoroutineDispatcher> defaultDispatcherProvider;

  public GetSortedPlaylistUseCase_Factory(
      Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<Context> contextProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    this.getSortedVideosUseCaseProvider = getSortedVideosUseCaseProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.contextProvider = contextProvider;
    this.defaultDispatcherProvider = defaultDispatcherProvider;
  }

  @Override
  public GetSortedPlaylistUseCase get() {
    return newInstance(getSortedVideosUseCaseProvider.get(), preferencesRepositoryProvider.get(), contextProvider.get(), defaultDispatcherProvider.get());
  }

  public static GetSortedPlaylistUseCase_Factory create(
      javax.inject.Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedPlaylistUseCase_Factory(Providers.asDaggerProvider(getSortedVideosUseCaseProvider), Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(defaultDispatcherProvider));
  }

  public static GetSortedPlaylistUseCase_Factory create(
      Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<Context> contextProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedPlaylistUseCase_Factory(getSortedVideosUseCaseProvider, preferencesRepositoryProvider, contextProvider, defaultDispatcherProvider);
  }

  public static GetSortedPlaylistUseCase newInstance(GetSortedVideosUseCase getSortedVideosUseCase,
      PreferencesRepository preferencesRepository, Context context,
      CoroutineDispatcher defaultDispatcher) {
    return new GetSortedPlaylistUseCase(getSortedVideosUseCase, preferencesRepository, context, defaultDispatcher);
  }
}
