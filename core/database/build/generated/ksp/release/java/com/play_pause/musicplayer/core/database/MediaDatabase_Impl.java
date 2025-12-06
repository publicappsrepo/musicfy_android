package com.play_pause.musicplayer.core.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.play_pause.musicplayer.core.database.dao.DirectoryDao;
import com.play_pause.musicplayer.core.database.dao.DirectoryDao_Impl;
import com.play_pause.musicplayer.core.database.dao.MediumDao;
import com.play_pause.musicplayer.core.database.dao.MediumDao_Impl;
import com.play_pause.musicplayer.core.database.dao.MediumStateDao;
import com.play_pause.musicplayer.core.database.dao.MediumStateDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MediaDatabase_Impl extends MediaDatabase {
  private volatile MediumDao _mediumDao;

  private volatile MediumStateDao _mediumStateDao;

  private volatile DirectoryDao _directoryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `directories` (`path` TEXT NOT NULL, `filename` TEXT NOT NULL, `last_modified` INTEGER NOT NULL, `parent_path` TEXT, PRIMARY KEY(`path`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `media` (`uri` TEXT NOT NULL, `path` TEXT NOT NULL, `filename` TEXT NOT NULL, `parent_path` TEXT NOT NULL, `last_modified` INTEGER NOT NULL, `size` INTEGER NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `media_store_id` INTEGER NOT NULL, `format` TEXT, `thumbnail_path` TEXT, PRIMARY KEY(`uri`))");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_media_uri` ON `media` (`uri`)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_media_path` ON `media` (`path`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `media_state` (`uri` TEXT NOT NULL, `playback_position` INTEGER NOT NULL, `audio_track_index` INTEGER, `subtitle_track_index` INTEGER, `playback_speed` REAL, `last_played_time` INTEGER, `external_subs` TEXT NOT NULL, `video_scale` REAL NOT NULL, PRIMARY KEY(`uri`))");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_media_state_uri` ON `media_state` (`uri`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `video_stream_info` (`stream_index` INTEGER NOT NULL, `title` TEXT, `codec_name` TEXT NOT NULL, `language` TEXT, `disposition` INTEGER NOT NULL, `bit_rate` INTEGER NOT NULL, `frame_rate` REAL NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `medium_uri` TEXT NOT NULL, PRIMARY KEY(`medium_uri`, `stream_index`), FOREIGN KEY(`medium_uri`) REFERENCES `media`(`uri`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `audio_stream_info` (`stream_index` INTEGER NOT NULL, `title` TEXT, `codec_name` TEXT NOT NULL, `language` TEXT, `disposition` INTEGER NOT NULL, `bit_rate` INTEGER NOT NULL, `sample_format` TEXT, `sample_rate` INTEGER NOT NULL, `channels` INTEGER NOT NULL, `channel_layout` TEXT, `medium_uri` TEXT NOT NULL, PRIMARY KEY(`medium_uri`, `stream_index`), FOREIGN KEY(`medium_uri`) REFERENCES `media`(`uri`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `subtitle_stream_info` (`stream_index` INTEGER NOT NULL, `title` TEXT, `codec_name` TEXT NOT NULL, `language` TEXT, `disposition` INTEGER NOT NULL, `medium_uri` TEXT NOT NULL, PRIMARY KEY(`medium_uri`, `stream_index`), FOREIGN KEY(`medium_uri`) REFERENCES `media`(`uri`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6be344134e034f2a16bb88d7849a0fda')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `directories`");
        db.execSQL("DROP TABLE IF EXISTS `media`");
        db.execSQL("DROP TABLE IF EXISTS `media_state`");
        db.execSQL("DROP TABLE IF EXISTS `video_stream_info`");
        db.execSQL("DROP TABLE IF EXISTS `audio_stream_info`");
        db.execSQL("DROP TABLE IF EXISTS `subtitle_stream_info`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsDirectories = new HashMap<String, TableInfo.Column>(4);
        _columnsDirectories.put("path", new TableInfo.Column("path", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectories.put("filename", new TableInfo.Column("filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectories.put("last_modified", new TableInfo.Column("last_modified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectories.put("parent_path", new TableInfo.Column("parent_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDirectories = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDirectories = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDirectories = new TableInfo("directories", _columnsDirectories, _foreignKeysDirectories, _indicesDirectories);
        final TableInfo _existingDirectories = TableInfo.read(db, "directories");
        if (!_infoDirectories.equals(_existingDirectories)) {
          return new RoomOpenHelper.ValidationResult(false, "directories(com.play_pause.musicplayer.core.database.entities.DirectoryEntity).\n"
                  + " Expected:\n" + _infoDirectories + "\n"
                  + " Found:\n" + _existingDirectories);
        }
        final HashMap<String, TableInfo.Column> _columnsMedia = new HashMap<String, TableInfo.Column>(12);
        _columnsMedia.put("uri", new TableInfo.Column("uri", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("filename", new TableInfo.Column("filename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("parent_path", new TableInfo.Column("parent_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("last_modified", new TableInfo.Column("last_modified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("size", new TableInfo.Column("size", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("width", new TableInfo.Column("width", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("height", new TableInfo.Column("height", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("media_store_id", new TableInfo.Column("media_store_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("format", new TableInfo.Column("format", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedia.put("thumbnail_path", new TableInfo.Column("thumbnail_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMedia = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMedia = new HashSet<TableInfo.Index>(2);
        _indicesMedia.add(new TableInfo.Index("index_media_uri", true, Arrays.asList("uri"), Arrays.asList("ASC")));
        _indicesMedia.add(new TableInfo.Index("index_media_path", true, Arrays.asList("path"), Arrays.asList("ASC")));
        final TableInfo _infoMedia = new TableInfo("media", _columnsMedia, _foreignKeysMedia, _indicesMedia);
        final TableInfo _existingMedia = TableInfo.read(db, "media");
        if (!_infoMedia.equals(_existingMedia)) {
          return new RoomOpenHelper.ValidationResult(false, "media(com.play_pause.musicplayer.core.database.entities.MediumEntity).\n"
                  + " Expected:\n" + _infoMedia + "\n"
                  + " Found:\n" + _existingMedia);
        }
        final HashMap<String, TableInfo.Column> _columnsMediaState = new HashMap<String, TableInfo.Column>(8);
        _columnsMediaState.put("uri", new TableInfo.Column("uri", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("playback_position", new TableInfo.Column("playback_position", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("audio_track_index", new TableInfo.Column("audio_track_index", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("subtitle_track_index", new TableInfo.Column("subtitle_track_index", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("playback_speed", new TableInfo.Column("playback_speed", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("last_played_time", new TableInfo.Column("last_played_time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("external_subs", new TableInfo.Column("external_subs", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaState.put("video_scale", new TableInfo.Column("video_scale", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMediaState = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMediaState = new HashSet<TableInfo.Index>(1);
        _indicesMediaState.add(new TableInfo.Index("index_media_state_uri", true, Arrays.asList("uri"), Arrays.asList("ASC")));
        final TableInfo _infoMediaState = new TableInfo("media_state", _columnsMediaState, _foreignKeysMediaState, _indicesMediaState);
        final TableInfo _existingMediaState = TableInfo.read(db, "media_state");
        if (!_infoMediaState.equals(_existingMediaState)) {
          return new RoomOpenHelper.ValidationResult(false, "media_state(com.play_pause.musicplayer.core.database.entities.MediumStateEntity).\n"
                  + " Expected:\n" + _infoMediaState + "\n"
                  + " Found:\n" + _existingMediaState);
        }
        final HashMap<String, TableInfo.Column> _columnsVideoStreamInfo = new HashMap<String, TableInfo.Column>(10);
        _columnsVideoStreamInfo.put("stream_index", new TableInfo.Column("stream_index", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("codec_name", new TableInfo.Column("codec_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("disposition", new TableInfo.Column("disposition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("bit_rate", new TableInfo.Column("bit_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("frame_rate", new TableInfo.Column("frame_rate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("width", new TableInfo.Column("width", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("height", new TableInfo.Column("height", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideoStreamInfo.put("medium_uri", new TableInfo.Column("medium_uri", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVideoStreamInfo = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysVideoStreamInfo.add(new TableInfo.ForeignKey("media", "CASCADE", "NO ACTION", Arrays.asList("medium_uri"), Arrays.asList("uri")));
        final HashSet<TableInfo.Index> _indicesVideoStreamInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVideoStreamInfo = new TableInfo("video_stream_info", _columnsVideoStreamInfo, _foreignKeysVideoStreamInfo, _indicesVideoStreamInfo);
        final TableInfo _existingVideoStreamInfo = TableInfo.read(db, "video_stream_info");
        if (!_infoVideoStreamInfo.equals(_existingVideoStreamInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "video_stream_info(com.play_pause.musicplayer.core.database.entities.VideoStreamInfoEntity).\n"
                  + " Expected:\n" + _infoVideoStreamInfo + "\n"
                  + " Found:\n" + _existingVideoStreamInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsAudioStreamInfo = new HashMap<String, TableInfo.Column>(11);
        _columnsAudioStreamInfo.put("stream_index", new TableInfo.Column("stream_index", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("codec_name", new TableInfo.Column("codec_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("disposition", new TableInfo.Column("disposition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("bit_rate", new TableInfo.Column("bit_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("sample_format", new TableInfo.Column("sample_format", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("sample_rate", new TableInfo.Column("sample_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("channels", new TableInfo.Column("channels", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("channel_layout", new TableInfo.Column("channel_layout", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioStreamInfo.put("medium_uri", new TableInfo.Column("medium_uri", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAudioStreamInfo = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAudioStreamInfo.add(new TableInfo.ForeignKey("media", "CASCADE", "NO ACTION", Arrays.asList("medium_uri"), Arrays.asList("uri")));
        final HashSet<TableInfo.Index> _indicesAudioStreamInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAudioStreamInfo = new TableInfo("audio_stream_info", _columnsAudioStreamInfo, _foreignKeysAudioStreamInfo, _indicesAudioStreamInfo);
        final TableInfo _existingAudioStreamInfo = TableInfo.read(db, "audio_stream_info");
        if (!_infoAudioStreamInfo.equals(_existingAudioStreamInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "audio_stream_info(com.play_pause.musicplayer.core.database.entities.AudioStreamInfoEntity).\n"
                  + " Expected:\n" + _infoAudioStreamInfo + "\n"
                  + " Found:\n" + _existingAudioStreamInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsSubtitleStreamInfo = new HashMap<String, TableInfo.Column>(6);
        _columnsSubtitleStreamInfo.put("stream_index", new TableInfo.Column("stream_index", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubtitleStreamInfo.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubtitleStreamInfo.put("codec_name", new TableInfo.Column("codec_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubtitleStreamInfo.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubtitleStreamInfo.put("disposition", new TableInfo.Column("disposition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubtitleStreamInfo.put("medium_uri", new TableInfo.Column("medium_uri", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubtitleStreamInfo = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSubtitleStreamInfo.add(new TableInfo.ForeignKey("media", "CASCADE", "NO ACTION", Arrays.asList("medium_uri"), Arrays.asList("uri")));
        final HashSet<TableInfo.Index> _indicesSubtitleStreamInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubtitleStreamInfo = new TableInfo("subtitle_stream_info", _columnsSubtitleStreamInfo, _foreignKeysSubtitleStreamInfo, _indicesSubtitleStreamInfo);
        final TableInfo _existingSubtitleStreamInfo = TableInfo.read(db, "subtitle_stream_info");
        if (!_infoSubtitleStreamInfo.equals(_existingSubtitleStreamInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "subtitle_stream_info(com.play_pause.musicplayer.core.database.entities.SubtitleStreamInfoEntity).\n"
                  + " Expected:\n" + _infoSubtitleStreamInfo + "\n"
                  + " Found:\n" + _existingSubtitleStreamInfo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6be344134e034f2a16bb88d7849a0fda", "8d5acff5216965538e2c6c2b7afd863a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "directories","media","media_state","video_stream_info","audio_stream_info","subtitle_stream_info");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `directories`");
      _db.execSQL("DELETE FROM `media`");
      _db.execSQL("DELETE FROM `media_state`");
      _db.execSQL("DELETE FROM `video_stream_info`");
      _db.execSQL("DELETE FROM `audio_stream_info`");
      _db.execSQL("DELETE FROM `subtitle_stream_info`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MediumDao.class, MediumDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MediumStateDao.class, MediumStateDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DirectoryDao.class, DirectoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MediumDao mediumDao() {
    if (_mediumDao != null) {
      return _mediumDao;
    } else {
      synchronized(this) {
        if(_mediumDao == null) {
          _mediumDao = new MediumDao_Impl(this);
        }
        return _mediumDao;
      }
    }
  }

  @Override
  public MediumStateDao mediumStateDao() {
    if (_mediumStateDao != null) {
      return _mediumStateDao;
    } else {
      synchronized(this) {
        if(_mediumStateDao == null) {
          _mediumStateDao = new MediumStateDao_Impl(this);
        }
        return _mediumStateDao;
      }
    }
  }

  @Override
  public DirectoryDao directoryDao() {
    if (_directoryDao != null) {
      return _directoryDao;
    } else {
      synchronized(this) {
        if(_directoryDao == null) {
          _directoryDao = new DirectoryDao_Impl(this);
        }
        return _directoryDao;
      }
    }
  }
}
