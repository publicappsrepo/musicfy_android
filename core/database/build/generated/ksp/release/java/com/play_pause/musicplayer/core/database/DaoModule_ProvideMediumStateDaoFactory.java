package com.play_pause.musicplayer.core.database;

import com.play_pause.musicplayer.core.database.dao.MediumStateDao;
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
public final class DaoModule_ProvideMediumStateDaoFactory implements Factory<MediumStateDao> {
  private final Provider<MediaDatabase> dbProvider;

  public DaoModule_ProvideMediumStateDaoFactory(Provider<MediaDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public MediumStateDao get() {
    return provideMediumStateDao(dbProvider.get());
  }

  public static DaoModule_ProvideMediumStateDaoFactory create(
      javax.inject.Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideMediumStateDaoFactory(Providers.asDaggerProvider(dbProvider));
  }

  public static DaoModule_ProvideMediumStateDaoFactory create(Provider<MediaDatabase> dbProvider) {
    return new DaoModule_ProvideMediumStateDaoFactory(dbProvider);
  }

  public static MediumStateDao provideMediumStateDao(MediaDatabase db) {
    return Preconditions.checkNotNullFromProvides(DaoModule.INSTANCE.provideMediumStateDao(db));
  }
}
