package com.practice.olegtojgildin.unittestpractice_meet_20.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DBManager {
    private DbHelper dbHelper;

    public DBManager(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    private static DBManager INSTANCE;

    public static DBManager getInstance(final Context context) {
        DBManager instance = INSTANCE;
        if (instance == null) {
            synchronized (DBManager.class) {
                instance = INSTANCE;
                if (instance == null) {
                    instance = INSTANCE = new DBManager(context);
                }
            }
        }
        return instance;
    }

    public void addResult(int res) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            db.beginTransaction();

            ContentValues values = new ContentValues();
            values.put(DbHelper.CALCULATE_TABLE, res);
            Log.d("addResult",Integer.toString(res));
            db.insertOrThrow(DbHelper.CALCULATE_TABLE, null, values);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.v("SQLiteExeption", e.getMessage());
        } finally {
            if (db != null) {
                if (db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
                db = null;
            }
        }
    }
    public int getResult() {
        int result = 0;
        SQLiteDatabase db = null;

        try {
            db = dbHelper.getReadableDatabase();
            db.beginTransaction();

            final Cursor cursor = db.query(DbHelper.CALCULATE_TABLE, null, null,
                    null, null, null, null);
            if (cursor.moveToLast()) {
                result = cursor.getInt(cursor.getColumnIndex(DbHelper.TEMP_RESULT));
                Log.w(TAG, String.valueOf(result));
            }
            cursor.close();

            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage());
        } finally {
            if (db != null) {
                if (db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
                db = null;
            }
        }
        return result;
    }
    public void saveResult(final int result) {
        SQLiteDatabase db = null;

        try {
            db = dbHelper.getReadableDatabase();
            db.beginTransaction();

            final ContentValues values = new ContentValues();
            values.put(DbHelper.TEMP_RESULT, result);

            db.insert(DbHelper.CALCULATE_TABLE, null, values);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage());
        } finally {
            if (db != null) {
                if (db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
                db = null;
            }
        }
    }
}
