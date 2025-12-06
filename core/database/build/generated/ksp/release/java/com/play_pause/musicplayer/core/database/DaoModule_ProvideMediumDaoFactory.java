package com.play_pause.musicplayer.core.database;

import com.play_pause.musicplayer.core.database.dao.MediumDao;
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
public final class DaoModule_ProvideMediumDaoFactory implements Factory<MediumDao> {
  private final Provider<MediaDatabase> dbProvider;

  public DaoModule_ProvideMediumDaoFactory(Provider<MediaDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public MediumDao get() {
    return provideMediumDao(dbProvider.get());
  }

  public static DaoModule_ProvideMediumDaoFactory create(
      javax.inject.Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideMediumDaoFactory(Providers.asDaggerProvider(dbProvider));
  }

  public static DaoModule_ProvideMediumDaoFactory create(Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideMediumDaoFactory(dbProvider);
  }

  public static MediumDao provideMediumDao(MediaDatabase db) {
    return Preconditions.checkNotNullFromProvides(DaoModule.INSTANCE.provideMediumDao(db));
  }
}
