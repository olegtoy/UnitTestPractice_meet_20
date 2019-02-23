package com.practice.olegtojgildin.unittestpractice_meet_20.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int VERSION_DB=2;
    public static final String DB_NAME="calculate.db";
    public static final String CALCULATE_TABLE="CALCULATE";
    public static final String TEMP_RESULT="temp_result";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DbHelper(Context context){
        this(context,DB_NAME,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createEmptyTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        deleteTables(db);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }

    public void createEmptyTables(SQLiteDatabase database){
        database.execSQL( "CREATE TABLE "+CALCULATE_TABLE+" ( "+TEMP_RESULT+ " integer"+" )");
    }
    private void deleteTables(SQLiteDatabase database){
        database.execSQL( "DROP TABLE IF EXISTS "+CALCULATE_TABLE );
    }
}
