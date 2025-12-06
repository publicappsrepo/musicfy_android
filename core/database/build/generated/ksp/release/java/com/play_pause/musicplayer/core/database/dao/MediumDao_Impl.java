package com.play_pause.musicplayer.core.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.play_pause.musicplayer.core.database.entities.MediumEntity;
import com.play_pause.musicplayer.core.database.entities.MediumStateEntity;
import com.play_pause.musicplayer.core.database.entities.SubtitleStreamInfoEntity;
import com.play_pause.musicplayer.core.database.entities.VideoStreamInfoEntity;
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
public final class MediumDao_Impl implements MediumDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<MediumEntity> __upsertionAdapterOfMediumEntity;

  private final EntityUpsertionAdapter<VideoStreamInfoEntity> __upsertionAdapterOfVideoStreamInfoEntity;

  private final EntityUpsertionAdapter<AudioStreamInfoEntity> __upsertionAdapterOfAudioStreamInfoEntity;

  private final EntityUpsertionAdapter<SubtitleStreamInfoEntity> __upsertionAdapterOfSubtitleStreamInfoEntity;

  public MediumDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfMediumEntity = new EntityUpsertionAdapter<MediumEntity>(new EntityInsertionAdapter<MediumEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `media` (`uri`,`path`,`filename`,`parent_path`,`last_modified`,`size`,`width`,`height`,`duration`,`media_store_id`,`format`,`thumbnail_path`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MediumEntity entity) {
        statement.bindString(1, entity.getUriString());
        statement.bindString(2, entity.getPath());
        statement.bindString(3, entity.getName());
        statement.bindString(4, entity.getParentPath());
        statement.bindLong(5, entity.getModified());
        statement.bindLong(6, entity.getSize());
        statement.bindLong(7, entity.getWidth());
        statement.bindLong(8, entity.getHeight());
        statement.bindLong(9, entity.getDuration());
        statement.bindLong(10, entity.getMediaStoreId());
        if (entity.getFormat() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getFormat());
        }
        if (entity.getThumbnailPath() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getThumbnailPath());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<MediumEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `media` SET `uri` = ?,`path` = ?,`filename` = ?,`parent_path` = ?,`last_modified` = ?,`size` = ?,`width` = ?,`height` = ?,`duration` = ?,`media_store_id` = ?,`format` = ?,`thumbnail_path` = ? WHERE `uri` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MediumEntity entity) {
        statement.bindString(1, entity.getUriString());
        statement.bindString(2, entity.getPath());
        statement.bindString(3, entity.getName());
        statement.bindString(4, entity.getParentPath());
        statement.bindLong(5, entity.getModified());
        statement.bindLong(6, entity.getSize());
        statement.bindLong(7, entity.getWidth());
        statement.bindLong(8, entity.getHeight());
        statement.bindLong(9, entity.getDuration());
        statement.bindLong(10, entity.getMediaStoreId());
        if (entity.getFormat() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getFormat());
        }
        if (entity.getThumbnailPath() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getThumbnailPath());
        }
        statement.bindString(13, entity.getUriString());
      }
    });
    this.__upsertionAdapterOfVideoStreamInfoEntity = new EntityUpsertionAdapter<VideoStreamInfoEntity>(new EntityInsertionAdapter<VideoStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `video_stream_info` (`stream_index`,`title`,`codec_name`,`language`,`disposition`,`bit_rate`,`frame_rate`,`width`,`height`,`medium_uri`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VideoStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindLong(6, entity.getBitRate());
        statement.bindDouble(7, entity.getFrameRate());
        statement.bindLong(8, entity.getFrameWidth());
        statement.bindLong(9, entity.getFrameHeight());
        statement.bindString(10, entity.getMediumUri());
      }
    }, new EntityDeletionOrUpdateAdapter<VideoStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `video_stream_info` SET `stream_index` = ?,`title` = ?,`codec_name` = ?,`language` = ?,`disposition` = ?,`bit_rate` = ?,`frame_rate` = ?,`width` = ?,`height` = ?,`medium_uri` = ? WHERE `medium_uri` = ? AND `stream_index` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VideoStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindLong(6, entity.getBitRate());
        statement.bindDouble(7, entity.getFrameRate());
        statement.bindLong(8, entity.getFrameWidth());
        statement.bindLong(9, entity.getFrameHeight());
        statement.bindString(10, entity.getMediumUri());
        statement.bindString(11, entity.getMediumUri());
        statement.bindLong(12, entity.getIndex());
      }
    });
    this.__upsertionAdapterOfAudioStreamInfoEntity = new EntityUpsertionAdapter<AudioStreamInfoEntity>(new EntityInsertionAdapter<AudioStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `audio_stream_info` (`stream_index`,`title`,`codec_name`,`language`,`disposition`,`bit_rate`,`sample_format`,`sample_rate`,`channels`,`channel_layout`,`medium_uri`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AudioStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindLong(6, entity.getBitRate());
        if (entity.getSampleFormat() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSampleFormat());
        }
        statement.bindLong(8, entity.getSampleRate());
        statement.bindLong(9, entity.getChannels());
        if (entity.getChannelLayout() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getChannelLayout());
        }
        statement.bindString(11, entity.getMediumUri());
      }
    }, new EntityDeletionOrUpdateAdapter<AudioStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `audio_stream_info` SET `stream_index` = ?,`title` = ?,`codec_name` = ?,`language` = ?,`disposition` = ?,`bit_rate` = ?,`sample_format` = ?,`sample_rate` = ?,`channels` = ?,`channel_layout` = ?,`medium_uri` = ? WHERE `medium_uri` = ? AND `stream_index` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AudioStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindLong(6, entity.getBitRate());
        if (entity.getSampleFormat() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSampleFormat());
        }
        statement.bindLong(8, entity.getSampleRate());
        statement.bindLong(9, entity.getChannels());
        if (entity.getChannelLayout() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getChannelLayout());
        }
        statement.bindString(11, entity.getMediumUri());
        statement.bindString(12, entity.getMediumUri());
        statement.bindLong(13, entity.getIndex());
      }
    });
    this.__upsertionAdapterOfSubtitleStreamInfoEntity = new EntityUpsertionAdapter<SubtitleStreamInfoEntity>(new EntityInsertionAdapter<SubtitleStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `subtitle_stream_info` (`stream_index`,`title`,`codec_name`,`language`,`disposition`,`medium_uri`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SubtitleStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindString(6, entity.getMediumUri());
      }
    }, new EntityDeletionOrUpdateAdapter<SubtitleStreamInfoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `subtitle_stream_info` SET `stream_index` = ?,`title` = ?,`codec_name` = ?,`language` = ?,`disposition` = ?,`medium_uri` = ? WHERE `medium_uri` = ? AND `stream_index` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SubtitleStreamInfoEntity entity) {
        statement.bindLong(1, entity.getIndex());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindString(3, entity.getCodecName());
        if (entity.getLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLanguage());
        }
        statement.bindLong(5, entity.getDisposition());
        statement.bindString(6, entity.getMediumUri());
        statement.bindString(7, entity.getMediumUri());
        statement.bindLong(8, entity.getIndex());
      }
    });
  }

  @Override
  public Object upsert(final MediumEntity medium, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMediumEntity.upsert(medium);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsertAll(final List<MediumEntity> media,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMediumEntity.upsert(media);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public void upsertVideoStreamInfo(final VideoStreamInfoEntity videoStreamInfoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfVideoStreamInfoEntity.upsert(videoStreamInfoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void upsertAudioStreamInfo(final AudioStreamInfoEntity audioStreamInfoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfAudioStreamInfoEntity.upsert(audioStreamInfoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void upsertSubtitleStreamInfo(final SubtitleStreamInfoEntity subtitleStreamInfoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfSubtitleStreamInfoEntity.upsert(subtitleStreamInfoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object get(final String uri, final Continuation<? super MediumEntity> $completion) {
    final String _sql = "SELECT * FROM media WHERE uri = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uri);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MediumEntity>() {
      @Override
      @Nullable
      public MediumEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
          final MediumEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new MediumEntity(_tmpUriString,_tmpPath,_tmpName,_tmpParentPath,_tmpModified,_tmpSize,_tmpWidth,_tmpHeight,_tmpDuration,_tmpMediaStoreId,_tmpFormat,_tmpThumbnailPath);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<MediumEntity> getAsFlow(final String uri) {
    final String _sql = "SELECT * FROM media WHERE uri = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uri);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"media"}, new Callable<MediumEntity>() {
      @Override
      @Nullable
      public MediumEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
          final MediumEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new MediumEntity(_tmpUriString,_tmpPath,_tmpName,_tmpParentPath,_tmpModified,_tmpSize,_tmpWidth,_tmpHeight,_tmpDuration,_tmpMediaStoreId,_tmpFormat,_tmpThumbnailPath);
          } else {
            _result = null;
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
  public Flow<List<MediumEntity>> getAll() {
    final String _sql = "SELECT * FROM media";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"media"}, new Callable<List<MediumEntity>>() {
      @Override
      @NonNull
      public List<MediumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
          final List<MediumEntity> _result = new ArrayList<MediumEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MediumEntity _item;
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
            _item = new MediumEntity(_tmpUriString,_tmpPath,_tmpName,_tmpParentPath,_tmpModified,_tmpSize,_tmpWidth,_tmpHeight,_tmpDuration,_tmpMediaStoreId,_tmpFormat,_tmpThumbnailPath);
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
  public Flow<List<MediumEntity>> getAllFromDirectory(final String directoryPath) {
    final String _sql = "SELECT * FROM media WHERE parent_path = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, directoryPath);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"media"}, new Callable<List<MediumEntity>>() {
      @Override
      @NonNull
      public List<MediumEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
          final List<MediumEntity> _result = new ArrayList<MediumEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MediumEntity _item;
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
            _item = new MediumEntity(_tmpUriString,_tmpPath,_tmpName,_tmpParentPath,_tmpModified,_tmpSize,_tmpWidth,_tmpHeight,_tmpDuration,_tmpMediaStoreId,_tmpFormat,_tmpThumbnailPath);
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
  public Object getWithInfo(final String uri,
      final Continuation<? super MediumWithInfo> $completion) {
    final String _sql = "SELECT * FROM media WHERE uri = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uri);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<MediumWithInfo>() {
      @Override
      @Nullable
      public MediumWithInfo call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
            final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
            final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
            final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
            final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
            final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
            final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
            final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
            final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
            final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
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
            final MediumWithInfo _result;
            if (_cursor.moveToFirst()) {
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
              final String _tmpKey_4;
              _tmpKey_4 = _cursor.getString(_cursorIndexOfUriString);
              _tmpMediumStateEntity = _collectionMediumStateEntity.get(_tmpKey_4);
              final VideoStreamInfoEntity _tmpVideoStreamInfo;
              final String _tmpKey_5;
              _tmpKey_5 = _cursor.getString(_cursorIndexOfUriString);
              _tmpVideoStreamInfo = _collectionVideoStreamInfo.get(_tmpKey_5);
              final ArrayList<AudioStreamInfoEntity> _tmpAudioStreamsInfoCollection;
              final String _tmpKey_6;
              _tmpKey_6 = _cursor.getString(_cursorIndexOfUriString);
              _tmpAudioStreamsInfoCollection = _collectionAudioStreamsInfo.get(_tmpKey_6);
              final ArrayList<SubtitleStreamInfoEntity> _tmpSubtitleStreamsInfoCollection;
              final String _tmpKey_7;
              _tmpKey_7 = _cursor.getString(_cursorIndexOfUriString);
              _tmpSubtitleStreamsInfoCollection = _collectionSubtitleStreamsInfo.get(_tmpKey_7);
              _result = new MediumWithInfo(_tmpMediumEntity,_tmpMediumStateEntity,_tmpVideoStreamInfo,_tmpAudioStreamsInfoCollection,_tmpSubtitleStreamsInfoCollection);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MediumWithInfo>> getAllWithInfo() {
    final String _sql = "SELECT * FROM media";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"media_state", "video_stream_info",
        "audio_stream_info", "subtitle_stream_info",
        "media"}, new Callable<List<MediumWithInfo>>() {
      @Override
      @NonNull
      public List<MediumWithInfo> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
            final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
            final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
            final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
            final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
            final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
            final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
            final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
            final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
            final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
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
            final List<MediumWithInfo> _result = new ArrayList<MediumWithInfo>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final MediumWithInfo _item;
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
              final String _tmpKey_4;
              _tmpKey_4 = _cursor.getString(_cursorIndexOfUriString);
              _tmpMediumStateEntity = _collectionMediumStateEntity.get(_tmpKey_4);
              final VideoStreamInfoEntity _tmpVideoStreamInfo;
              final String _tmpKey_5;
              _tmpKey_5 = _cursor.getString(_cursorIndexOfUriString);
              _tmpVideoStreamInfo = _collectionVideoStreamInfo.get(_tmpKey_5);
              final ArrayList<AudioStreamInfoEntity> _tmpAudioStreamsInfoCollection;
              final String _tmpKey_6;
              _tmpKey_6 = _cursor.getString(_cursorIndexOfUriString);
              _tmpAudioStreamsInfoCollection = _collectionAudioStreamsInfo.get(_tmpKey_6);
              final ArrayList<SubtitleStreamInfoEntity> _tmpSubtitleStreamsInfoCollection;
              final String _tmpKey_7;
              _tmpKey_7 = _cursor.getString(_cursorIndexOfUriString);
              _tmpSubtitleStreamsInfoCollection = _collectionSubtitleStreamsInfo.get(_tmpKey_7);
              _item = new MediumWithInfo(_tmpMediumEntity,_tmpMediumStateEntity,_tmpVideoStreamInfo,_tmpAudioStreamsInfoCollection,_tmpSubtitleStreamsInfoCollection);
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
  public Flow<List<MediumWithInfo>> getAllWithInfoFromDirectory(final String directoryPath) {
    final String _sql = "SELECT * FROM media WHERE parent_path = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, directoryPath);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"media_state", "video_stream_info",
        "audio_stream_info", "subtitle_stream_info",
        "media"}, new Callable<List<MediumWithInfo>>() {
      @Override
      @NonNull
      public List<MediumWithInfo> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
            final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
            final int _cursorIndexOfParentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_path");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified");
            final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
            final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "width");
            final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
            final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
            final int _cursorIndexOfMediaStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "media_store_id");
            final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
            final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_path");
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
            final List<MediumWithInfo> _result = new ArrayList<MediumWithInfo>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final MediumWithInfo _item;
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
              final String _tmpKey_4;
              _tmpKey_4 = _cursor.getString(_cursorIndexOfUriString);
              _tmpMediumStateEntity = _collectionMediumStateEntity.get(_tmpKey_4);
              final VideoStreamInfoEntity _tmpVideoStreamInfo;
              final String _tmpKey_5;
              _tmpKey_5 = _cursor.getString(_cursorIndexOfUriString);
              _tmpVideoStreamInfo = _collectionVideoStreamInfo.get(_tmpKey_5);
              final ArrayList<AudioStreamInfoEntity> _tmpAudioStreamsInfoCollection;
              final String _tmpKey_6;
              _tmpKey_6 = _cursor.getString(_cursorIndexOfUriString);
              _tmpAudioStreamsInfoCollection = _collectionAudioStreamsInfo.get(_tmpKey_6);
              final ArrayList<SubtitleStreamInfoEntity> _tmpSubtitleStreamsInfoCollection;
              final String _tmpKey_7;
              _tmpKey_7 = _cursor.getString(_cursorIndexOfUriString);
              _tmpSubtitleStreamsInfoCollection = _collectionSubtitleStreamsInfo.get(_tmpKey_7);
              _item = new MediumWithInfo(_tmpMediumEntity,_tmpMediumStateEntity,_tmpVideoStreamInfo,_tmpAudioStreamsInfoCollection,_tmpSubtitleStreamsInfoCollection);
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
  public Object delete(final List<String> uris, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM media WHERE uri in (");
        final int _inputSize = uris.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        final String _sql = _stringBuilder.toString();
        final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
        int _argIndex = 1;
        for (String _item : uris) {
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
}
