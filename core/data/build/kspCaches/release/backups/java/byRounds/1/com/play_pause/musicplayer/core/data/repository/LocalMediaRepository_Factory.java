package com.play_pause.musicplayer.core.data.repository;

import com.play_pause.musicplayer.core.database.dao.DirectoryDao;
import com.play_pause.musicplayer.core.database.dao.MediumDao;
import com.play_pause.musicplayer.core.database.dao.MediumStateDao;
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
public final class LocalMediaRepository_Factory implements Factory<LocalMediaRepository> {
  private final Provider<MediumDao> mediumDaoProvider;

  private final Provider<MediumStateDao> mediumStateDaoProvider;

  private final Provider<DirectoryDao> directoryDaoProvider;

  public LocalMediaRepository_Factory(Provider<MediumDao> mediumDaoProvider,
      Provider<MediumStateDao> mediumStateDaoProvider,
      Provider<DirectoryDao> directoryDaoProvider) {
    this.mediumDaoProvider = mediumDaoProvider;
    this.mediumStateDaoProvider = mediumStateDaoProvider;
    this.directoryDaoProvider = directoryDaoProvider;
  }

  @Override
  public LocalMediaRepository get() {
    return newInstance(mediumDaoProvider.get(), mediumStateDaoProvider.get(), directoryDaoProvider.get());
  }

  public static LocalMediaRepository_Factory create(
      javax.inject.Provider<MediumDao> mediumDaoProvider,
      javax.inject.Provider<MediumStateDao> mediumStateDaoProvider,
      javax.inject.Provider<DirectoryDao> directoryDaoProvider) {
    return new LocalMediaRepository_Factory(Providers.asDaggerProvider(mediumDaoProvider), Providers.asDaggerProvider(mediumStateDaoProvider), Providers.asDaggerProvider(directoryDaoProvider));
  }

  public static LocalMediaRepository_Factory create(Provider<MediumDao> mediumDaoProvider,
      Provider<MediumStateDao> mediumStateDaoProvider,
      Provider<DirectoryDao> directoryDaoProvider) {
    return new LocalMediaRepository_Factory(mediumDaoProvider, mediumStateDaoProvider, directoryDaoProvider);
  }

  public static LocalMediaRepository newInstance(MediumDao mediumDao, MediumStateDao mediumStateDao,
      DirectoryDao directoryDao) {
    return new LocalMediaRepository(mediumDao, mediumStateDao, directoryDao);
  }
}
