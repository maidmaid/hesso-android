package com.maid.childrensportplanning.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
     * Insert a children record
     * @param firstname firstname
     * @return ID of new children inserted
     */
    public static long insertChildren(String firstname) {
        ContentValues values = new ContentValues();
        values.put(DbContract.Children.COLUMN_NAME_FIRSTNAME, firstname);
        long id = db.insert(DbContract.Children.TABLE_NAME, null, values);
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
     * @param children ID's children
     * @param sport ID's sport
     * @param date date
     * @return ID of new planning inserted
     */
    public static long insertPlanning(long children, long sport, String date) {
        ContentValues values = new ContentValues();
        values.put(DbContract.Planning.COLUMN_NAME_CHILDREN, children);
        values.put(DbContract.Planning.COLUMN_NAME_SPORT, sport);
        values.put(DbContract.Planning.COLUMN_NAME_DATE, date);
        long id = db.insert(DbContract.Planning.TABLE_NAME, null, values);
        return id;
    }
}
