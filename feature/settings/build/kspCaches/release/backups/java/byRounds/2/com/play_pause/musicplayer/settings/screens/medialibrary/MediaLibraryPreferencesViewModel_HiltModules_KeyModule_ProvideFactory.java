package com.play_pause.musicplayer.settings.screens.medialibrary;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
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
public final class MediaLibraryPreferencesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
  @Override
  public Boolean get() {
    return provide();
  }

  public static MediaLibraryPreferencesViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static boolean provide() {
    return MediaLibraryPreferencesViewModel_HiltModules.KeyModule.provide();
  }

  private static final class InstanceHolder {
    static final MediaLibraryPreferencesViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MediaLibraryPreferencesViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
