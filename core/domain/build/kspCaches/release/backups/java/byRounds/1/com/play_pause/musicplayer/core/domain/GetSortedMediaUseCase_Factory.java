package com.play_pause.musicplayer.core.domain;

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
public final class GetSortedMediaUseCase_Factory implements Factory<GetSortedMediaUseCase> {
  private final Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider;

  private final Provider<GetSortedFoldersUseCase> getSortedFoldersUseCaseProvider;

  private final Provider<GetSortedFolderTreeUseCase> getSortedFolderTreeUseCaseProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<CoroutineDispatcher> defaultDispatcherProvider;

  public GetSortedMediaUseCase_Factory(
      Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      Provider<GetSortedFoldersUseCase> getSortedFoldersUseCaseProvider,
      Provider<GetSortedFolderTreeUseCase> getSortedFolderTreeUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    this.getSortedVideosUseCaseProvider = getSortedVideosUseCaseProvider;
    this.getSortedFoldersUseCaseProvider = getSortedFoldersUseCaseProvider;
    this.getSortedFolderTreeUseCaseProvider = getSortedFolderTreeUseCaseProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.defaultDispatcherProvider = defaultDispatcherProvider;
  }

  @Override
  public GetSortedMediaUseCase get() {
    return newInstance(getSortedVideosUseCaseProvider.get(), getSortedFoldersUseCaseProvider.get(), getSortedFolderTreeUseCaseProvider.get(), preferencesRepositoryProvider.get(), defaultDispatcherProvider.get());
  }

  public static GetSortedMediaUseCase_Factory create(
      javax.inject.Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      javax.inject.Provider<GetSortedFoldersUseCase> getSortedFoldersUseCaseProvider,
      javax.inject.Provider<GetSortedFolderTreeUseCase> getSortedFolderTreeUseCaseProvider,
      javax.inject.Provider<PreferencesRepository> preferencesRepositoryProvider,
      javax.inject.Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedMediaUseCase_Factory(Providers.asDaggerProvider(getSortedVideosUseCaseProvider), Providers.asDaggerProvider(getSortedFoldersUseCaseProvider), Providers.asDaggerProvider(getSortedFolderTreeUseCaseProvider), Providers.asDaggerProvider(preferencesRepositoryProvider), Providers.asDaggerProvider(defaultDispatcherProvider));
  }

  public static GetSortedMediaUseCase_Factory create(
      Provider<GetSortedVideosUseCase> getSortedVideosUseCaseProvider,
      Provider<GetSortedFoldersUseCase> getSortedFoldersUseCaseProvider,
      Provider<GetSortedFolderTreeUseCase> getSortedFolderTreeUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new GetSortedMediaUseCase_Factory(getSortedVideosUseCaseProvider, getSortedFoldersUseCaseProvider, getSortedFolderTreeUseCaseProvider, preferencesRepositoryProvider, defaultDispatcherProvider);
  }

  public static GetSortedMediaUseCase newInstance(GetSortedVideosUseCase getSortedVideosUseCase,
      GetSortedFoldersUseCase getSortedFoldersUseCase,
      GetSortedFolderTreeUseCase getSortedFolderTreeUseCase,
      PreferencesRepository preferencesRepository, CoroutineDispatcher defaultDispatcher) {
    return new GetSortedMediaUseCase(getSortedVideosUseCase, getSortedFoldersUseCase, getSortedFolderTreeUseCase, preferencesRepository, defaultDispatcher);
  }
}
