package com.play_pause.musicplayer.core.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.play_pause.musicplayer.core.database.entities.AudioStreamInfoEntity;
import com.play_pause.musicplayer.core.database.entities.DirectoryEntity;
import com.play_pause.musicplayer.core.database.entities.MediumEntity;
import com.play_pause.musicplayer.core.database.entities.MediumStateEntity;
import com.play_pause.musicplayer.core.database.entities.SubtitleStreamInfoEntity;
import com.play_pause.musicplayer.core.database.entities.VideoStreamInfoEntity;
import com.play_pause.musicplayer.core.database.relations.DirectoryWithMedia;
import com.play_pause.musicplayer.core.database.relations.MediumWithInfo;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DirectoryDao_Impl implements DirectoryDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<DirectoryEntity> __upsertionAdapterOfDirectoryEntity;

  public DirectoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfDirectoryEntity = new EntityUpsertionAdapter<DirectoryEntity>(new EntityInsertionAdapter<DirectoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `directories` (`path`,`filename`,`last_modified`,`parent_path`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DirectoryEntity entity) {
        statement.bindString(1, entity.getPath());
        statement.bindString(2, entity.getName());
        statement.bindLong(3, entity.getModified());
        if (entity.getParentPath() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getParentPath());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<DirectoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `directories` SET `path` = ?,`filename` = ?,`last_modified` = ?,`parent_path` = ? WHERE `path` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DirectoryEntity entity) {
        statement.bindString(1, entity.getPath());
        statement.bindString(2, entity.getName());
        statement.bindLong(3, entity.getModified());
        if (entity.getParentPath() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getParentPath());
        }
        statement.bindString(5, entity.getPath());
      }
    });
  }

  @Override
  public Object upsert(final DirectoryEntity directory,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfDirectoryEntity.upsert(directory);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsertAll(final List<DirectoryEntity> directories,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfDirectoryEntity.upsert(directories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DirectoryEntity>> getAll() {
    final String _sql = "SELECT * FROM directories";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"directories"}, new Callable<List<DirectoryEntity>>() {
      @Override
      @NonNull
      public List<DirectoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
          final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
          final List<DirectoryEntity> _result = new ArrayList<DirectoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DirectoryEntity _item;
            final String _tmpPath;
            _tmpPath = _cursor.getString(_cursorIndexOfPath);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final long _tmpModified;
            _tmpModified = _cursor.getLong(_cursorIndexOfModified);
            final String _tmpParentPath;
            if (_cursor.isNull(_cursorIndexOfParentPath)) {
              _tmpParentPath = null;
            } else {
              _tmpParentPath = _cursor.getString(_cursorIndexOfParentPath);
            }
            _item = new DirectoryEntity(_tmpPath,_tmpName,_tmpModified,_tmpParentPath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<DirectoryWithMedia>> getAllWithMedia() {
    final String _sql = "SELECT * FROM directories";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"media_state", "video_stream_info",
        "audio_stream_info", "subtitle_stream_info", "media",
        "directories"}, new Callable<List<DirectoryWithMedia>>() {
      @Override
      @NonNull
      public List<DirectoryWithMedia> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
            final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
            final ArrayMap<String, ArrayList<MediumWithInfo>> _collectionMedia = new ArrayMap<String, ArrayList<MediumWithInfo>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey;
              _tmpKey = _cursor.getString(_cursorIndexOfPath);
              if (!_collectionMedia.containsKey(_tmpKey)) {
                _collectionMedia.put(_tmpKey, new ArrayList<MediumWithInfo>());
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipmediaAscomPlayPauseMusicplayerCoreDatabaseRelationsMediumWithInfo(_collectionMedia);
            final List<DirectoryWithMedia> _result = new ArrayList<DirectoryWithMedia>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final DirectoryWithMedia _item;
              final DirectoryEntity _tmpDirectory;
              final String _tmpPath;
              _tmpPath = _cursor.getString(_cursorIndexOfPath);
              final String _tmpName;
              _tmpName = _cursor.getString(_cursorIndexOfName);
              final long _tmpModified;
              _tmpModified = _cursor.getLong(_cursorIndexOfModified);
              final String _tmpParentPath;
              if (_cursor.isNull(_cursorIndexOfParentPath)) {
                _tmpParentPath = null;
              } else {
                _tmpParentPath = _cursor.getString(_cursorIndexOfParentPath);
              }
              _tmpDirectory = new DirectoryEntity(_tmpPath,_tmpName,_tmpModified,_tmpParentPath);
              final ArrayList<MediumWithInfo> _tmpMediaCollection;
              final String _tmpKey_1;
              _tmpKey_1 = _cursor.getString(_cursorIndexOfPath);
              _tmpMediaCollection = _collectionMedia.get(_tmpKey_1);
              _item = new DirectoryWithMedia(_tmpDirectory,_tmpMediaCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object delete(final List<String> paths, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM directories WHERE path in (");
        final int _inputSize = paths.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        final String _sql = _stringBuilder.toString();
        final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
        int _argIndex = 1;
        for (String _item : paths) {
          _stmt.bindString(_argIndex, _item);
          _argIndex++;
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipmediaStateAscomPlayPauseMusicplayerCoreDatabaseEntitiesMediumStateEntity(
      @NonNull final ArrayMap<String, MediumStateEntity> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, false, (map) -> {
        __fetchRelationshipmediaStateAscomPlayPauseMusicplayerCoreDatabaseEntitiesMediumStateEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `uri`,`playback_position`,`audio_track_index`,`subtitle_track_index`,`playback_speed`,`last_played_time`,`external_subs`,`video_scale` FROM `media_state` WHERE `uri` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      _stmt.bindString(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "uri");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfUriString = 0;
      final int _cursorIndexOfPlaybackPosition = 1;
      final int _cursorIndexOfAudioTrackIndex = 2;
      final int _cursorIndexOfSubtitleTrackIndex = 3;
      final int _cursorIndexOfPlaybackSpeed = 4;
      final int _cursorIndexOfLastPlayedTime = 5;
      final int _cursorIndexOfExternalSubs = 6;
      final int _cursorIndexOfVideoScale = 7;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final MediumStateEntity _item_1;
          final String _tmpUriString;
          _tmpUriString = _cursor.getString(_cursorIndexOfUriString);
          final long _tmpPlaybackPosition;
          _tmpPlaybackPosition = _cursor.getLong(_cursorIndexOfPlaybackPosition);
          final Integer _tmpAudioTrackIndex;
          if (_cursor.isNull(_cursorIndexOfAudioTrackIndex)) {
            _tmpAudioTrackIndex = null;
          } else {
            _tmpAudioTrackIndex = _cursor.getInt(_cursorIndexOfAudioTrackIndex);
          }
          final Integer _tmpSubtitleTrackIndex;
          if (_cursor.isNull(_cursorIndexOfSubtitleTrackIndex)) {
            _tmpSubtitleTrackIndex = null;
          } else {
            _tmpSubtitleTrackIndex = _cursor.getInt(_cursorIndexOfSubtitleTrackIndex);
          }
          final Float _tmpPlaybackSpeed;
          if (_cursor.isNull(_cursorIndexOfPlaybackSpeed)) {
            _tmpPlaybackSpeed = null;
          } else {
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
          }
          final Long _tmpLastPlayedTime;
          if (_cursor.isNull(_cursorIndexOfLastPlayedTime)) {
            _tmpLastPlayedTime = null;
          } else {
            _tmpLastPlayedTime = _cursor.getLong(_cursorIndexOfLastPlayedTime);
          }
          final String _tmpExternalSubs;
          _tmpExternalSubs = _cursor.getString(_cursorIndexOfExternalSubs);
          final float _tmpVideoScale;
          _tmpVideoScale = _cursor.getFloat(_cursorIndexOfVideoScale);
          _item_1 = new MediumStateEntity(_tmpUriString,_tmpPlaybackPosition,_tmpAudioTrackIndex,_tmpSubtitleTrackIndex,_tmpPlaybackSpeed,_tmpLastPlayedTime,_tmpExternalSubs,_tmpVideoScale);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipvideoStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesVideoStreamInfoEntity(
      @NonNull final ArrayMap<String, VideoStreamInfoEntity> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, false, (map) -> {
        __fetchRelationshipvideoStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesVideoStreamInfoEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `stream_index`,`title`,`codec_name`,`language`,`disposition`,`bit_rate`,`frame_rate`,`width`,`height`,`medium_uri` FROM `video_stream_info` WHERE `medium_uri` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      _stmt.bindString(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "medium_uri");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfIndex = 0;
      final int _cursorIndexOfTitle = 1;
      final int _cursorIndexOfCodecName = 2;
      final int _cursorIndexOfLanguage = 3;
      final int _cursorIndexOfDisposition = 4;
      final int _cursorIndexOfBitRate = 5;
      final int _cursorIndexOfFrameRate = 6;
      final int _cursorIndexOfFrameWidth = 7;
      final int _cursorIndexOfFrameHeight = 8;
      final int _cursorIndexOfMediumUri = 9;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final VideoStreamInfoEntity _item_1;
          final int _tmpIndex;
          _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final String _tmpCodecName;
          _tmpCodecName = _cursor.getString(_cursorIndexOfCodecName);
          final String _tmpLanguage;
          if (_cursor.isNull(_cursorIndexOfLanguage)) {
            _tmpLanguage = null;
          } else {
            _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
          }
          final int _tmpDisposition;
          _tmpDisposition = _cursor.getInt(_cursorIndexOfDisposition);
          final long _tmpBitRate;
          _tmpBitRate = _cursor.getLong(_cursorIndexOfBitRate);
          final double _tmpFrameRate;
          _tmpFrameRate = _cursor.getDouble(_cursorIndexOfFrameRate);
          final int _tmpFrameWidth;
          _tmpFrameWidth = _cursor.getInt(_cursorIndexOfFrameWidth);
          final int _tmpFrameHeight;
          _tmpFrameHeight = _cursor.getInt(_cursorIndexOfFrameHeight);
          final String _tmpMediumUri;
          _tmpMediumUri = _cursor.getString(_cursorIndexOfMediumUri);
          _item_1 = new VideoStreamInfoEntity(_tmpIndex,_tmpTitle,_tmpCodecName,_tmpLanguage,_tmpDisposition,_tmpBitRate,_tmpFrameRate,_tmpFrameWidth,_tmpFrameHeight,_tmpMediumUri);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipaudioStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesAudioStreamInfoEntity(
      @NonNull final ArrayMap<String, ArrayList<AudioStreamInfoEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, true, (map) -> {
        __fetchRelationshipaudioStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesAudioStreamInfoEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `stream_index`,`title`,`codec_name`,`language`,`disposition`,`bit_rate`,`sample_format`,`sample_rate`,`channels`,`channel_layout`,`medium_uri` FROM `audio_stream_info` WHERE `medium_uri` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      _stmt.bindString(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "medium_uri");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfIndex = 0;
      final int _cursorIndexOfTitle = 1;
      final int _cursorIndexOfCodecName = 2;
      final int _cursorIndexOfLanguage = 3;
      final int _cursorIndexOfDisposition = 4;
      final int _cursorIndexOfBitRate = 5;
      final int _cursorIndexOfSampleFormat = 6;
      final int _cursorIndexOfSampleRate = 7;
      final int _cursorIndexOfChannels = 8;
      final int _cursorIndexOfChannelLayout = 9;
      final int _cursorIndexOfMediumUri = 10;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_itemKeyIndex);
        final ArrayList<AudioStreamInfoEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final AudioStreamInfoEntity _item_1;
          final int _tmpIndex;
          _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final String _tmpCodecName;
          _tmpCodecName = _cursor.getString(_cursorIndexOfCodecName);
          final String _tmpLanguage;
          if (_cursor.isNull(_cursorIndexOfLanguage)) {
            _tmpLanguage = null;
          } else {
            _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
          }
          final int _tmpDisposition;
          _tmpDisposition = _cursor.getInt(_cursorIndexOfDisposition);
          final long _tmpBitRate;
          _tmpBitRate = _cursor.getLong(_cursorIndexOfBitRate);
          final String _tmpSampleFormat;
          if (_cursor.isNull(_cursorIndexOfSampleFormat)) {
            _tmpSampleFormat = null;
          } else {
            _tmpSampleFormat = _cursor.getString(_cursorIndexOfSampleFormat);
          }
          final int _tmpSampleRate;
          _tmpSampleRate = _cursor.getInt(_cursorIndexOfSampleRate);
          final int _tmpChannels;
          _tmpChannels = _cursor.getInt(_cursorIndexOfChannels);
          final String _tmpChannelLayout;
          if (_cursor.isNull(_cursorIndexOfChannelLayout)) {
            _tmpChannelLayout = null;
          } else {
            _tmpChannelLayout = _cursor.getString(_cursorIndexOfChannelLayout);
          }
          final String _tmpMediumUri;
          _tmpMediumUri = _cursor.getString(_cursorIndexOfMediumUri);
          _item_1 = new AudioStreamInfoEntity(_tmpIndex,_tmpTitle,_tmpCodecName,_tmpLanguage,_tmpDisposition,_tmpBitRate,_tmpSampleFormat,_tmpSampleRate,_tmpChannels,_tmpChannelLayout,_tmpMediumUri);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipsubtitleStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesSubtitleStreamInfoEntity(
      @NonNull final ArrayMap<String, ArrayList<SubtitleStreamInfoEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, true, (map) -> {
        __fetchRelationshipsubtitleStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesSubtitleStreamInfoEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `stream_index`,`title`,`codec_name`,`language`,`disposition`,`medium_uri` FROM `subtitle_stream_info` WHERE `medium_uri` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      _stmt.bindString(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "medium_uri");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfIndex = 0;
      final int _cursorIndexOfTitle = 1;
      final int _cursorIndexOfCodecName = 2;
      final int _cursorIndexOfLanguage = 3;
      final int _cursorIndexOfDisposition = 4;
      final int _cursorIndexOfMediumUri = 5;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_itemKeyIndex);
        final ArrayList<SubtitleStreamInfoEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final SubtitleStreamInfoEntity _item_1;
          final int _tmpIndex;
          _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final String _tmpCodecName;
          _tmpCodecName = _cursor.getString(_cursorIndexOfCodecName);
          final String _tmpLanguage;
          if (_cursor.isNull(_cursorIndexOfLanguage)) {
            _tmpLanguage = null;
          } else {
            _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
          }
          final int _tmpDisposition;
          _tmpDisposition = _cursor.getInt(_cursorIndexOfDisposition);
          final String _tmpMediumUri;
          _tmpMediumUri = _cursor.getString(_cursorIndexOfMediumUri);
          _item_1 = new SubtitleStreamInfoEntity(_tmpIndex,_tmpTitle,_tmpCodecName,_tmpLanguage,_tmpDisposition,_tmpMediumUri);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipmediaAscomPlayPauseMusicplayerCoreDatabaseRelationsMediumWithInfo(
      @NonNull final ArrayMap<String, ArrayList<MediumWithInfo>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, true, (map) -> {
        __fetchRelationshipmediaAscomPlayPauseMusicplayerCoreDatabaseRelationsMediumWithInfo(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `uri`,`path`,`filename`,`parent_path`,`last_modified`,`size`,`width`,`height`,`duration`,`media_store_id`,`format`,`thumbnail_path` FROM `media` WHERE `parent_path` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      _stmt.bindString(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, true, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "parent_path");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfUriString = 0;
      final int _cursorIndexOfPath = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfParentPath = 3;
      final int _cursorIndexOfModified = 4;
      final int _cursorIndexOfSize = 5;
      final int _cursorIndexOfWidth = 6;
      final int _cursorIndexOfHeight = 7;
      final int _cursorIndexOfDuration = 8;
      final int _cursorIndexOfMediaStoreId = 9;
      final int _cursorIndexOfFormat = 10;
      final int _cursorIndexOfThumbnailPath = 11;
      final ArrayMap<String, MediumStateEntity> _collectionMediumStateEntity = new ArrayMap<String, MediumStateEntity>();
      final ArrayMap<String, VideoStreamInfoEntity> _collectionVideoStreamInfo = new ArrayMap<String, VideoStreamInfoEntity>();
      final ArrayMap<String, ArrayList<AudioStreamInfoEntity>> _collectionAudioStreamsInfo = new ArrayMap<String, ArrayList<AudioStreamInfoEntity>>();
      final ArrayMap<String, ArrayList<SubtitleStreamInfoEntity>> _collectionSubtitleStreamsInfo = new ArrayMap<String, ArrayList<SubtitleStreamInfoEntity>>();
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfUriString);
        _collectionMediumStateEntity.put(_tmpKey, null);
        final String _tmpKey_1;
        _tmpKey_1 = _cursor.getString(_cursorIndexOfUriString);
        _collectionVideoStreamInfo.put(_tmpKey_1, null);
        final String _tmpKey_2;
        _tmpKey_2 = _cursor.getString(_cursorIndexOfUriString);
        if (!_collectionAudioStreamsInfo.containsKey(_tmpKey_2)) {
          _collectionAudioStreamsInfo.put(_tmpKey_2, new ArrayList<AudioStreamInfoEntity>());
        }
        final String _tmpKey_3;
        _tmpKey_3 = _cursor.getString(_cursorIndexOfUriString);
        if (!_collectionSubtitleStreamsInfo.containsKey(_tmpKey_3)) {
          _collectionSubtitleStreamsInfo.put(_tmpKey_3, new ArrayList<SubtitleStreamInfoEntity>());
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipmediaStateAscomPlayPauseMusicplayerCoreDatabaseEntitiesMediumStateEntity(_collectionMediumStateEntity);
      __fetchRelationshipvideoStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesVideoStreamInfoEntity(_collectionVideoStreamInfo);
      __fetchRelationshipaudioStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesAudioStreamInfoEntity(_collectionAudioStreamsInfo);
      __fetchRelationshipsubtitleStreamInfoAscomPlayPauseMusicplayerCoreDatabaseEntitiesSubtitleStreamInfoEntity(_collectionSubtitleStreamsInfo);
      while (_cursor.moveToNext()) {
        final String _tmpKey_4;
        _tmpKey_4 = _cursor.getString(_itemKeyIndex);
        final ArrayList<MediumWithInfo> _tmpRelation = _map.get(_tmpKey_4);
        if (_tmpRelation != null) {
          final MediumWithInfo _item_1;
          final MediumEntity _tmpMediumEntity;
          final String _tmpUriString;
          _tmpUriString = _cursor.getString(_cursorIndexOfUriString);
          final String _tmpPath;
          _tmpPath = _cursor.getString(_cursorIndexOfPath);
          final String _tmpName;
          _tmpName = _cursor.getString(_cursorIndexOfName);
          final String _tmpParentPath;
          _tmpParentPath = _cursor.getString(_cursorIndexOfParentPath);
          final long _tmpModified;
          _tmpModified = _cursor.getLong(_cursorIndexOfModified);
          final long _tmpSize;
          _tmpSize = _cursor.getLong(_cursorIndexOfSize);
          final int _tmpWidth;
          _tmpWidth = _cursor.getInt(_cursorIndexOfWidth);
          final int _tmpHeight;
          _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
          final long _tmpDuration;
          _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
          final long _tmpMediaStoreId;
          _tmpMediaStoreId = _cursor.getLong(_cursorIndexOfMediaStoreId);
          final String _tmpFormat;
          if (_cursor.isNull(_cursorIndexOfFormat)) {
            _tmpFormat = null;
          } else {
            _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
          }
          final String _tmpThumbnailPath;
          if (_cursor.isNull(_cursorIndexOfThumbnailPath)) {
            _tmpThumbnailPath = null;
          } else {
            _tmpThumbnailPath = _cursor.getString(_cursorIndexOfThumbnailPath);
          }
          _tmpMediumEntity = new MediumEntity(_tmpUriString,_tmpPath,_tmpName,_tmpParentPath,_tmpModified,_tmpSize,_tmpWidth,_tmpHeight,_tmpDuration,_tmpMediaStoreId,_tmpFormat,_tmpThumbnailPath);
          final MediumStateEntity _tmpMediumStateEntity;
          final String _tmpKey_5;
          _tmpKey_5 = _cursor.getString(_cursorIndexOfUriString);
          _tmpMediumStateEntity = _collectionMediumStateEntity.get(_tmpKey_5);
          final VideoStreamInfoEntity _tmpVideoStreamInfo;
          final String _tmpKey_6;
          _tmpKey_6 = _cursor.getString(_cursorIndexOfUriString);
          _tmpVideoStreamInfo = _collectionVideoStreamInfo.get(_tmpKey_6);
          final ArrayList<AudioStreamInfoEntity> _tmpAudioStreamsInfoCollection;
          final String _tmpKey_7;
          _tmpKey_7 = _cursor.getString(_cursorIndexOfUriString);
          _tmpAudioStreamsInfoCollection = _collectionAudioStreamsInfo.get(_tmpKey_7);
          final ArrayList<SubtitleStreamInfoEntity> _tmpSubtitleStreamsInfoCollection;
          final String _tmpKey_8;
          _tmpKey_8 = _cursor.getString(_cursorIndexOfUriString);
          _tmpSubtitleStreamsInfoCollection = _collectionSubtitleStreamsInfo.get(_tmpKey_8);
          _item_1 = new MediumWithInfo(_tmpMediumEntity,_tmpMediumStateEntity,_tmpVideoStreamInfo,_tmpAudioStreamsInfoCollection,_tmpSubtitleStreamsInfoCollection);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
