package com.harproj.harottapp.db.resume_content;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ResumeContentDao_Impl implements ResumeContentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ResumeContent> __insertionAdapterOfResumeContent;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSource;

  private final SharedSQLiteStatement __preparedStmtOfClearDB;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDuration;

  public ResumeContentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfResumeContent = new EntityInsertionAdapter<ResumeContent>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ResumeContent` (`id`,`content_id`,`source_type`,`source_url`,`poster`,`name`,`year`,`position`,`duration`,`content_type`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ResumeContent value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getContent_id());
        if (value.getSource_type() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource_type());
        }
        if (value.getSource_url() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSource_url());
        }
        if (value.getPoster() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPoster());
        }
        if (value.getName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getName());
        }
        if (value.getYear() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getYear());
        }
        stmt.bindLong(8, value.getPosition());
        stmt.bindLong(9, value.getDuration());
        if (value.getContent_type() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getContent_type());
        }
        stmt.bindLong(11, value.getType());
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ResumeContent SET position = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ResumeContent WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSource = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ResumeContent SET source_type = ?, source_url = ?, type = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearDB = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ResumeContent";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDuration = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ResumeContent SET duration = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ResumeContent resumeContent) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResumeContent.insert(resumeContent);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final long position, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, position);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public void delete(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void updateSource(final String source_type, final String source_url, final int type,
      final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSource.acquire();
    int _argIndex = 1;
    if (source_type == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, source_type);
    }
    _argIndex = 2;
    if (source_url == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, source_url);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, type);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSource.release(_stmt);
    }
  }

  @Override
  public void clearDB() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearDB.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearDB.release(_stmt);
    }
  }

  @Override
  public void updateDuration(final long duration, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDuration.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, duration);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDuration.release(_stmt);
    }
  }

  @Override
  public List<ResumeContent> getResumeContents() {
    final String _sql = "SELECT `ResumeContent`.`id` AS `id`, `ResumeContent`.`content_id` AS `content_id`, `ResumeContent`.`source_type` AS `source_type`, `ResumeContent`.`source_url` AS `source_url`, `ResumeContent`.`poster` AS `poster`, `ResumeContent`.`name` AS `name`, `ResumeContent`.`year` AS `year`, `ResumeContent`.`position` AS `position`, `ResumeContent`.`duration` AS `duration`, `ResumeContent`.`content_type` AS `content_type`, `ResumeContent`.`type` AS `type` FROM ResumeContent";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfContentId = 1;
      final int _cursorIndexOfSourceType = 2;
      final int _cursorIndexOfSourceUrl = 3;
      final int _cursorIndexOfPoster = 4;
      final int _cursorIndexOfName = 5;
      final int _cursorIndexOfYear = 6;
      final int _cursorIndexOfPosition = 7;
      final int _cursorIndexOfDuration = 8;
      final int _cursorIndexOfContentType = 9;
      final int _cursorIndexOfType = 10;
      final List<ResumeContent> _result = new ArrayList<ResumeContent>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResumeContent _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpContent_id;
        _tmpContent_id = _cursor.getInt(_cursorIndexOfContentId);
        final String _tmpSource_type;
        if (_cursor.isNull(_cursorIndexOfSourceType)) {
          _tmpSource_type = null;
        } else {
          _tmpSource_type = _cursor.getString(_cursorIndexOfSourceType);
        }
        final String _tmpSource_url;
        if (_cursor.isNull(_cursorIndexOfSourceUrl)) {
          _tmpSource_url = null;
        } else {
          _tmpSource_url = _cursor.getString(_cursorIndexOfSourceUrl);
        }
        final String _tmpPoster;
        if (_cursor.isNull(_cursorIndexOfPoster)) {
          _tmpPoster = null;
        } else {
          _tmpPoster = _cursor.getString(_cursorIndexOfPoster);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpYear;
        if (_cursor.isNull(_cursorIndexOfYear)) {
          _tmpYear = null;
        } else {
          _tmpYear = _cursor.getString(_cursorIndexOfYear);
        }
        final long _tmpPosition;
        _tmpPosition = _cursor.getLong(_cursorIndexOfPosition);
        final long _tmpDuration;
        _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
        final String _tmpContent_type;
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _tmpContent_type = null;
        } else {
          _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        }
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        _item = new ResumeContent(_tmpId,_tmpContent_id,_tmpSource_type,_tmpSource_url,_tmpPoster,_tmpName,_tmpYear,_tmpPosition,_tmpDuration,_tmpContent_type,_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getResumeContentid(final int value) {
    final String _sql = "SELECT id FROM ResumeContent WHERE content_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, value);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getResumeContentPosition(final int value) {
    final String _sql = "SELECT position FROM ResumeContent WHERE content_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, value);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0L;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getResumeContentSourceType(final int value) {
    final String _sql = "SELECT source_type FROM ResumeContent WHERE content_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, value);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getResumeContentSourceUrl(final int value) {
    final String _sql = "SELECT source_url FROM ResumeContent WHERE content_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, value);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getResumeContentName(final int value) {
    final String _sql = "SELECT name FROM ResumeContent WHERE content_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, value);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
