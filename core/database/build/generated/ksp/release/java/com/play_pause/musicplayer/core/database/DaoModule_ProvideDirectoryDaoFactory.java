package com.play_pause.musicplayer.core.database;

import com.play_pause.musicplayer.core.database.dao.DirectoryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DaoModule_ProvideDirectoryDaoFactory implements Factory<DirectoryDao> {
  private final Provider<MediaDatabase> dbProvider;

  public DaoModule_ProvideDirectoryDaoFactory(Provider<MediaDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public DirectoryDao get() {
    return provideDirectoryDao(dbProvider.get());
  }

  public static DaoModule_ProvideDirectoryDaoFactory create(
      javax.inject.Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideDirectoryDaoFactory(Providers.asDaggerProvider(dbProvider));
  }

  public static DaoModule_ProvideDirectoryDaoFactory create(Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideDirectoryDaoFactory(dbProvider);
  }

  public static DirectoryDao provideDirectoryDao(MediaDatabase db) {
    return Preconditions.checkNotNullFromProvides(DaoModule.INSTANCE.provideDirectoryDao(db));
  }
}
