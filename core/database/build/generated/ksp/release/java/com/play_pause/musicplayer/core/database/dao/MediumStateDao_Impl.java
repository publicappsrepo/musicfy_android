package com.play_pause.musicplayer.core.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.play_pause.musicplayer.core.database.entities.MediumStateEntity;
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
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MediumStateDao_Impl implements MediumStateDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<MediumStateEntity> __upsertionAdapterOfMediumStateEntity;

  public MediumStateDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfMediumStateEntity = new EntityUpsertionAdapter<MediumStateEntity>(new EntityInsertionAdapter<MediumStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `media_state` (`uri`,`playback_position`,`audio_track_index`,`subtitle_track_index`,`playback_speed`,`last_played_time`,`external_subs`,`video_scale`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MediumStateEntity entity) {
        statement.bindString(1, entity.getUriString());
        statement.bindLong(2, entity.getPlaybackPosition());
        if (entity.getAudioTrackIndex() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getAudioTrackIndex());
        }
        if (entity.getSubtitleTrackIndex() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getSubtitleTrackIndex());
        }
        if (entity.getPlaybackSpeed() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getPlaybackSpeed());
        }
        if (entity.getLastPlayedTime() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getLastPlayedTime());
        }
        statement.bindString(7, entity.getExternalSubs());
        statement.bindDouble(8, entity.getVideoScale());
      }
    }, new EntityDeletionOrUpdateAdapter<MediumStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `media_state` SET `uri` = ?,`playback_position` = ?,`audio_track_index` = ?,`subtitle_track_index` = ?,`playback_speed` = ?,`last_played_time` = ?,`external_subs` = ?,`video_scale` = ? WHERE `uri` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MediumStateEntity entity) {
        statement.bindString(1, entity.getUriString());
        statement.bindLong(2, entity.getPlaybackPosition());
        if (entity.getAudioTrackIndex() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getAudioTrackIndex());
        }
        if (entity.getSubtitleTrackIndex() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getSubtitleTrackIndex());
        }
        if (entity.getPlaybackSpeed() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getPlaybackSpeed());
        }
        if (entity.getLastPlayedTime() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getLastPlayedTime());
        }
        statement.bindString(7, entity.getExternalSubs());
        statement.bindDouble(8, entity.getVideoScale());
        statement.bindString(9, entity.getUriString());
      }
    });
  }

  @Override
  public Object upsert(final MediumStateEntity mediumState,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMediumStateEntity.upsert(mediumState);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsertAll(final List<MediumStateEntity> mediaStates,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMediumStateEntity.upsert(mediaStates);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object get(final String uri, final Continuation<? super MediumStateEntity> $completion) {
    final String _sql = "SELECT * FROM media_state WHERE uri = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uri);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MediumStateEntity>() {
      @Override
      @Nullable
      public MediumStateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPlaybackPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_position");
          final int _cursorIndexOfAudioTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "audio_track_index");
          final int _cursorIndexOfSubtitleTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle_track_index");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_speed");
          final int _cursorIndexOfLastPlayedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "last_played_time");
          final int _cursorIndexOfExternalSubs = CursorUtil.getColumnIndexOrThrow(_cursor, "external_subs");
          final int _cursorIndexOfVideoScale = CursorUtil.getColumnIndexOrThrow(_cursor, "video_scale");
          final MediumStateEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new MediumStateEntity(_tmpUriString,_tmpPlaybackPosition,_tmpAudioTrackIndex,_tmpSubtitleTrackIndex,_tmpPlaybackSpeed,_tmpLastPlayedTime,_tmpExternalSubs,_tmpVideoScale);
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
  public Flow<MediumStateEntity> getAsFlow(final String uri) {
    final String _sql = "SELECT * FROM media_state WHERE uri = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uri);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"media_state"}, new Callable<MediumStateEntity>() {
      @Override
      @Nullable
      public MediumStateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPlaybackPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_position");
          final int _cursorIndexOfAudioTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "audio_track_index");
          final int _cursorIndexOfSubtitleTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle_track_index");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_speed");
          final int _cursorIndexOfLastPlayedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "last_played_time");
          final int _cursorIndexOfExternalSubs = CursorUtil.getColumnIndexOrThrow(_cursor, "external_subs");
          final int _cursorIndexOfVideoScale = CursorUtil.getColumnIndexOrThrow(_cursor, "video_scale");
          final MediumStateEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new MediumStateEntity(_tmpUriString,_tmpPlaybackPosition,_tmpAudioTrackIndex,_tmpSubtitleTrackIndex,_tmpPlaybackSpeed,_tmpLastPlayedTime,_tmpExternalSubs,_tmpVideoScale);
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
  public Flow<List<MediumStateEntity>> getAll() {
    final String _sql = "SELECT * FROM media_state";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"media_state"}, new Callable<List<MediumStateEntity>>() {
      @Override
      @NonNull
      public List<MediumStateEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriString = CursorUtil.getColumnIndexOrThrow(_cursor, "uri");
          final int _cursorIndexOfPlaybackPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_position");
          final int _cursorIndexOfAudioTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "audio_track_index");
          final int _cursorIndexOfSubtitleTrackIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle_track_index");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playback_speed");
          final int _cursorIndexOfLastPlayedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "last_played_time");
          final int _cursorIndexOfExternalSubs = CursorUtil.getColumnIndexOrThrow(_cursor, "external_subs");
          final int _cursorIndexOfVideoScale = CursorUtil.getColumnIndexOrThrow(_cursor, "video_scale");
          final List<MediumStateEntity> _result = new ArrayList<MediumStateEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MediumStateEntity _item;
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
            _item = new MediumStateEntity(_tmpUriString,_tmpPlaybackPosition,_tmpAudioTrackIndex,_tmpSubtitleTrackIndex,_tmpPlaybackSpeed,_tmpLastPlayedTime,_tmpExternalSubs,_tmpVideoScale);
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
  public Object delete(final List<String> uris, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM media_state WHERE uri in (");
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
}
