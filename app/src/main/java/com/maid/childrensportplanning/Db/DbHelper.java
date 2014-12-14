package com.maid.childrensportplanning.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database helper
 */
public class DbHelper extends SQLiteOpenHelper {
    /**
     * Constructor
     * @param context context
     */
    public DbHelper(Context context) {
        super(context, DbContract.DATABASE_NAME, null, DbContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbContract.Child.SQL_CREATE_TABLE);
        db.execSQL(DbContract.Sport.SQL_CREATE_TABLE);
        db.execSQL(DbContract.Planning.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbContract.Child.SQL_DELETE_TABLE);
        db.execSQL(DbContract.Sport.SQL_DELETE_TABLE);
        db.execSQL(DbContract.Planning.SQL_DELETE_TABLE);
        onCreate(db);
    }
}
