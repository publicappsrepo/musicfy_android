package com.play_pause.musicplayer.core.media.services;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class LocalMediaService_Factory implements Factory<LocalMediaService> {
  private final Provider<Context> contextProvider;

  public LocalMediaService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public LocalMediaService get() {
    return newInstance(contextProvider.get());
  }

  public static LocalMediaService_Factory create(javax.inject.Provider<Context> contextProvider) {
    return new LocalMediaService_Factory(Providers.asDaggerProvider(contextProvider));
  }

  public static LocalMediaService_Factory create(Provider<Context> contextProvider) {
    return new LocalMediaService_Factory(contextProvider);
  }

  public static LocalMediaService newInstance(Context context) {
    return new LocalMediaService(context);
  }
}
