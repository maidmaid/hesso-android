package com.maid.csp.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Database utils methods
 */
public class Db {
    public static SQLiteDatabase db;

    /**
     * Initialize database
     * @param context context used by DbHelper
     */
    public static void initialize(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Insert a child record
     * @param firstname firstname
     * @return ID of new children inserted
     */
    public static long insertChild(String firstname) {
        ContentValues values = new ContentValues();
        values.put(DbContract.Child.COLUMN_NAME_FIRSTNAME, firstname);
        long id = db.insert(DbContract.Child.TABLE_NAME, null, values);
        return id;
    }

    /**
     * Insert a sport record
     * @param name name
     * @return ID of new sport inserted
     */
    public static long insertSport(String name) {
        ContentValues values = new ContentValues();
        values.put(DbContract.Sport.COLUMN_NAME_NAME, name);
        long id = db.insert(DbContract.Sport.TABLE_NAME, null, values);
        return id;
    }

    /**
     * Insert a planning record
     * @param child ID's children
     * @param sport ID's sport
     * @param date date
     * @return ID of new planning inserted
     */
    public static long insertPlanning(long child, long sport, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContentValues values = new ContentValues();
        values.put(DbContract.Planning.COLUMN_NAME_CHILD, child);
        values.put(DbContract.Planning.COLUMN_NAME_SPORT, sport);
        values.put(DbContract.Planning.COLUMN_NAME_DATE, formatter.format(date));
        long id = db.insert(DbContract.Planning.TABLE_NAME, null, values);
        return id;
    }

    /**
     * Get all childrens
     * @return cursor containing children
     */
    public static DbCursor getChildren(){
        String[] projection = {
            DbContract.Child._ID,
            DbContract.Child.COLUMN_NAME_FIRSTNAME
        };

        Cursor c = db.query(DbContract.Child.TABLE_NAME, projection, null, null, null, null, DbContract.Child.COLUMN_NAME_FIRSTNAME);

        return new DbCursor(c);
    }

    /**
     * Get all sports
     * @return cursor containing sports
     */
    public static DbCursor getSports(){
        String[] projection = {
            DbContract.Sport._ID,
            DbContract.Sport.COLUMN_NAME_NAME
        };

        Cursor c = db.query(DbContract.Sport.TABLE_NAME, projection, null, null, null, null, DbContract.Sport.COLUMN_NAME_NAME);

        return new DbCursor(c);
    }

    /**
     * Get all plannings
     * @return cursor containing plannings
     */
    public static DbCursor getPlannings(){
        String[] projection = {
            DbContract.Planning._ID,
            DbContract.Planning.COLUMN_NAME_CHILD,
            DbContract.Planning.COLUMN_NAME_SPORT,
            DbContract.Planning.COLUMN_NAME_DATE,
        };

        Cursor c = db.query(DbContract.Planning.TABLE_NAME, projection, null, null, null, null, null);

        return new DbCursor(c);
    }

    /**
     * Get all plannings with sport and children joins
     * @return cursor containing planning with joins
     */
    public static DbCursor getPlanningsWithSportAndChildren() {
        String[] projection = {
            "p." + DbContract.Planning._ID,
            DbContract.Planning.COLUMN_NAME_CHILD,
            DbContract.Planning.COLUMN_NAME_SPORT,
            DbContract.Planning.COLUMN_NAME_DATE,
            DbContract.Sport.COLUMN_NAME_NAME,
            DbContract.Child.COLUMN_NAME_FIRSTNAME
        };

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(
            DbContract.Planning.TABLE_NAME + " p " +
            DbContract.Planning.SQL_JOIN_SPORT + " " +
            DbContract.Planning.SQL_JOIN_CHILDREN
        );

        Cursor c = qb.query(db, projection, null, null, null, null, null);

        return new DbCursor(c);
    }
}
